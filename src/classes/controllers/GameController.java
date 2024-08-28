package classes.controllers;

import classes.Card;
import classes.Deck;
import classes.Player;
import classes.lib.records.PlayersCard;
import classes.views.GameView;
import interfaces.GameEvaluation;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** The card game controller. */
public class GameController extends Controller<GameView> {

  /** The game evaluator to determine the winner. */
  final GameEvaluation gameEvaluator;

  /** The game deck. */
  final Deck deck;

  /** The players. */
  final ArrayList<Player> players;

  /** The game actual state. */
  GameState state;

  /** Winner for the game. */
  @Nullable Player winner = null;

  /** Main constructor. */
  public GameController(GameView view, Deck deck, GameEvaluation gameEvaluator) {
    super(view);
    this.deck = deck;
    this.gameEvaluator = gameEvaluator;
    players = new ArrayList<>();
    state = GameState.AddingPlayers;
  }

  /** Game loop. */
  public void run() {
    /* Adding players */
    while (state.equals(GameState.AddingPlayers)) {
      int previousPlayerAmount = players.size();
      view.promptForPlayerName();
      /* Need at least two players */
      if (players.size() >= 2
          /* Unchanged amount of players  ||  Max 5 players */
          && (previousPlayerAmount == players.size() || players.size() > 4)) {
        startGame();
      }
    }

    while (!state.equals(GameState.ClosingGame)) {
      switch (state) {
        case GameState.WinnerRevealed:
          view.promptForNewGame();
          break;
        case GameState.CardBattle:
          view.promptForFlip();
          break;
        default:
          return;
      }
    }
  }

  // --- METHODS ---

  /** Add a player to the game. */
  public void addPlayer(@NotNull String playersName) {
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

  // --- ACTIONS ---

  /** Start the game. */
  public void startGame() {
    if (!state.equals(GameState.CardBattle)) {
      deck.shuffle();
      for (Player player : players) {
        player.addCardToHand(deck.pickCard());
        view.showPlayerCardFacedDown(player.getId(), player.getName());
      }
      state = GameState.CardBattle;
    }
  }

  /** Close the game. */
  public void closeGame() {
    state = GameState.ClosingGame;
  }

  /** Flip and reveal the table cards. */
  public void flipCards() {
    ArrayList<PlayersCard> cardsOnTable = new ArrayList<>(players.size());

    for (Player player : players) {
      Card card = player.getCard(0);
      assert card != null;
      card.flip();
      view.showPlayerCardFacedUp(
          player.getId(), player.getName(),
          card.getColor().name(), card.getValue().name());
      cardsOnTable.add(new PlayersCard(player, card));
    }

    winner = gameEvaluator.evaluateWinner(cardsOnTable);
    state = GameState.WinnerRevealed;
    displayWinner();
    rebuildDeck();
  }

  /** Displays the winner. */
  private void displayWinner() {
    assert winner != null;
    view.showWinner(winner.getName());
  }

  /** Empties players hand to the deck. */
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

  /** Game state steps. */
  enum GameState {
    AddingPlayers,
    CardBattle,
    WinnerRevealed,
    ClosingGame
  }
}
