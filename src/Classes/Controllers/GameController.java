package Classes.Controllers;

import Classes.Card;
import Classes.Deck;
import Classes.Lib.Games.BasicGame;
import Classes.Player;
import Classes.Views.GameView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/** The card game controller */
public class GameController extends Controller<GameView> {

    enum GameState {
        AddingPlayers,
        CardBattle,
        WinnerRevealed,
        ClosingGame
    }

    /** The game deck */
    Deck deck;
    ArrayList<Player> players;
    GameState state;
    @Nullable Player winner = null;

    public GameController(GameView view, Deck deck) {
        super(view);
        this.deck = deck;
        players = new ArrayList<>();
        state = GameState.AddingPlayers;
    }

    // --- METHODS ---

    public void run() {
        /* Adding players */
        while (state.equals(GameState.AddingPlayers)) {
            int previousPlayerAmount = players.size();
            view.promptForPlayerName();
            if (
                /* Need at least two players, max 5 players */
                players.size() >= 2 && (
                    /* Unchanged amount of players */
                    previousPlayerAmount == players.size() ||
                     /* Max 5 players */
                    players.size() > 4
                )
            ) {
                startGame();
            }
        }

        while (!state.equals(GameState.ClosingGame)) {
            switch(state) {
                case GameState.WinnerRevealed:
                    view.promptForNewGame();
                    break;
                case GameState.CardBattle:
                    view.promptForFlip();
            }
        }
    }

    // --- ACTIONS ---

    public void addPLayer(@NotNull String playersName) {
        if (state.equals(GameState.AddingPlayers)) {

            if (players.stream().anyMatch((player -> player.getName().equals(playersName)))) {
                view.printMessage("Name '%s' is already used".formatted(playersName));
                return;
            }

            Player player = new Player(playersName);
            players.add(player);
            view.showPlayerName(player.getId(), player.getName());
        }
    }

    public void startGame() {
        if (!state.equals(GameState.CardBattle)) {
            deck.shuffle();
            for (Player player : players) {
                player.addCardToHand(deck.pickCard());
                view.showFaceDownCardForPLayer(player.getId(), player.getName());
            }
            state = GameState.CardBattle;
        }
    }

    public void closeGame() {
        state = GameState.ClosingGame;
    }

    public void flipCards() {
        BasicGame game = new BasicGame();

        for (Player player : players) {
            Card card = player.getCard(0);
            assert card != null;
            card.flip();
            view.showFaceUpCardForPLayer(
                player.getId(), player.getName(),
                card.getColor().name(), card.getValue().name()
            );
            game.addParticipant(player, card);
        }

        winner = game.evaluateWinner();
        state = GameState.WinnerRevealed;
        displayWinner();
        rebuildDeck();
    }

    /** Evaluate the player that wins the game */
    private @NotNull Player evaluateWinner() {

        class PlayersCard {
            final Player player;
            final Card   card;

            PlayersCard(Player player, Card card) {
                this.player = player;
                this.card = card;
            }
        }

        ArrayList<PlayersCard> tablePlayersCards = new ArrayList<>(4);
        for (Player player : players) {
            tablePlayersCards.add(new PlayersCard(player, player.getCard(0)));
        }

        /* Sort table cards : Compare values */
        tablePlayersCards.sort((PlayersCard a, PlayersCard b) -> {
            int cmp = b.card.getValue().value() - a.card.getValue().value();
            /* If ranks are equals */
            if (cmp == 0) {
                /* then sort by colors */
                return b.card.getColor().value() - a.card.getColor().value();
            }
            return cmp;
        });

        return tablePlayersCards.getFirst().player;
    }

    /** Displays the winner */
    private void displayWinner() {
        assert winner != null;
        view.showWinner(winner.getName());
    }

    /** Empties players hand to the deck */
    private void rebuildDeck() {
        winner = null;
        for (Player player : players) {
            int i = 0;
            @Nullable Card card = player.getCard(i);
            player.removeCard(i++);
            while (card != null) {
                deck.returnCard(card);
                card = player.getCard(i);
                player.removeCard(i++);
            }
        }
    }
}
