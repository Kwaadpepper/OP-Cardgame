package Classes.Controllers;

import Classes.Card;
import Classes.Deck;
import Classes.Interfaces.GameEvaluation;
import Classes.Lib.Records.PlayersCard;
import Classes.Player;
import Classes.Views.GameView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/** The card game controller */
public class GameController extends Controller<GameView> {

    /** Game state steps */
    enum GameState {
        AddingPlayers,
        CardBattle,
        WinnerRevealed,
        ClosingGame
    }

    /** The game evaluator to determine the winner */
    GameEvaluation gameEvaluator;

    /** The game deck */
    Deck deck;

    /** The players */
    ArrayList<Player> players;

    /** The game actual state */
    GameState state;

    /** Winner for the game */
    @Nullable Player winner = null;

    public GameController(GameView view, Deck deck, GameEvaluation gameEvaluator) {
        super(view);
        this.deck = deck;
        this.gameEvaluator = gameEvaluator;
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
        ArrayList<PlayersCard> cardsOnTable = new ArrayList<>(players.size());

        for (Player player : players) {
            Card card = player.getCard(0);
            assert card != null;
            card.flip();
            view.showFaceUpCardForPLayer(
                player.getId(), player.getName(),
                card.getColor().name(), card.getValue().name()
            );
            cardsOnTable.add(new PlayersCard(player, card));
        }

        winner = gameEvaluator.evaluateWinner(cardsOnTable);
        state = GameState.WinnerRevealed;
        displayWinner();
        rebuildDeck();
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
