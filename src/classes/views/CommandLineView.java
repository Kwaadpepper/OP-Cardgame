package classes.views;

import classes.controllers.Controller;
import classes.controllers.GameController;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** Console Game view. */
public class CommandLineView extends View {

  @Nullable private static Scanner scan = null;

  /** The view controller. */
  GameController controller;

  /** Main Constructor. */
  public CommandLineView() {
    scan = new Scanner(System.in);
  }

  public void setController(Controller controller) {
    this.controller = (GameController) controller;
  }

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
    printMessage("Press enter to flip cards");
    getNextLine();
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

  /** Print a message to the user. */
  public void printMessage(String message) {
    System.out.println(message);
  }

  /** Format the players info to display. */
  private String formatPlayerInfo(int playerId, String playerName) {
    return "[%d][%s]".formatted(playerId, playerName);
  }

  /** Prompt a user info. */
  private @NotNull String promptFor(@NotNull String ask) {
    @Nullable String nextLine = null;
    while (nextLine == null) {
      printMessage(ask);
      nextLine = getNextLine();
      if (nextLine == null) {
        printMessage("You need to enter a value !");
      }
    }
    return nextLine;
  }

  /** Get scanner next line. */
  private @Nullable String getNextLine() {
    try {
      assert scan != null;
      scan.reset();
      String nextLine = scan.nextLine();
      if (nextLine.isEmpty()) {
        return null;
      }
      return nextLine;
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
