package classes.views;

import java.util.NoSuchElementException;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** Console Game view. */
public class CommandLineView extends View {

  @Nullable private static Scanner scan = null;

  @Override
  public void createAndDisplayGui() {
    scan = new Scanner(System.in);
  }

  @Override
  public void promptForPlayerName() {
    printMessage("Enter 'x' and press enter to skip adding players anytime..");
    String playerName = promptFor("Enter player's name");

    if (!playerName.equals("x")) {
      controller.addPlayer(playerName);
    }
  }

  @Override
  public void promptForFlip() {
    printMessage("Press enter to flip cards");
    getNextLine();
    controller.flipCards();
  }

  @Override
  public void promptForNewGame() {
    String ask = promptFor("New Game [y/n] ?");
    if (ask.toLowerCase().startsWith("y")) {
      controller.startGame();
    } else {
      controller.closeGame();
    }
  }

  @Override
  public void showWinner(String playerName) {
    printMessage("And the winner is ..... %s !".formatted(playerName));
  }

  @Override
  public void showPlayerName(int playerId, String playerName) {
    printMessage(formatPlayerInfo(playerId, playerName));
  }

  @Override
  public void showPlayerCardFacedDown(int playerId, String playerName) {
    printMessage("%s[x][x]".formatted(formatPlayerInfo(playerId, playerName)));
  }

  @Override
  public void showPlayerCardFacedUp(int playerId, String playerName, String rank, String suit) {
    printMessage("%s[%s][%s]".formatted(formatPlayerInfo(playerId, playerName), rank, suit));
  }

  @Override
  public void printMessage(String message) {
    System.out.println(message);
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
