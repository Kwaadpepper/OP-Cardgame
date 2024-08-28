package classes.views;

import classes.controllers.Controller;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** Base View. */
public abstract class View<T extends Controller> {

  @Nullable private static Scanner scan = null;

  /** The view controller. */
  T controller;

  View() {
    scan = new Scanner(System.in);
  }

  /** Set the view controller. */
  public void setController(T controller) {
    this.controller = controller;
  }

  /** Print a message to the user. */
  public void printMessage(String message) {
    System.out.println(message);
  }

  /** Prompt a user info. */
  protected @NotNull String promptFor(@NotNull String ask) {
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

  /** Prompt any key from user to flip cards. */
  protected void pressAnyKeyToFlipCards() {
    printMessage("Press enter to flip cards");
    getNextLine();
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
