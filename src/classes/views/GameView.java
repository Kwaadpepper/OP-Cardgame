package classes.views;

import classes.controllers.GameController;

/** Console Game view. */
public class GameView extends View<GameController> {

  /** Prompt for a players name. */
  public void promptForPlayerName() {
    printMessage("Enter 'x' and press enter to skip adding players anytime..");
    String playerName = promptFor("Enter player's name");

    if (!playerName.equals("x")) {
      controller.addPlayer(playerName);
    }
  }

  /** Prompt user to flip cards. */
  public void promptForFlip() {
    pressAnyKeyToFlipCards();
    controller.flipCards();
  }

  /** Prompt the user to battle again. */
  public void promptForNewGame() {
    String ask = promptFor("New Game [y/n] ?");
    if (ask.toLowerCase().startsWith("y")) {
      controller.startGame();
    } else {
      controller.closeGame();
    }
  }

  /** Display the winners name. */
  public void showWinner(String playerName) {
    printMessage("And the winner is ..... %s !".formatted(playerName));
  }

  /** Show a players name. */
  public void showPlayerName(int playerId, String playerName) {
    printMessage(formatPlayerInfo(playerId, playerName));
  }

  /** Show cards faced down for a player. */
  public void showPlayerCardFacedDown(int playerId, String playerName) {
    printMessage("%s[x][x]".formatted(formatPlayerInfo(playerId, playerName)));
  }

  /** Show cards faced up for a player. */
  public void showPlayerCardFacedUp(int playerId, String playerName, String rank, String suit) {
    printMessage("%s[%s][%s]".formatted(formatPlayerInfo(playerId, playerName), rank, suit));
  }

  /** Format the players info to display. */
  private String formatPlayerInfo(int playerId, String playerName) {
    return "[%d][%s]".formatted(playerId, playerName);
  }
}
