package classes.views;

import classes.controllers.Controller;
import classes.controllers.GameController;
import frames.GameFrame;
import interfaces.views.GameViewable;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** For the game to be viewed in a Swing Interface. */
public class SwingView extends View implements GameViewable {

  /** The view controller. */
  GameController controller;

  /** View frame. */
  GameFrame frame;

  /** Pubic constructor. */
  public SwingView() {
    // create main frame
    frame = new GameFrame("MVC-SOLID-Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);

    // display vertically
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    frame.setVisible(true);
  }

  public void setController(Controller controller) {
    this.controller = (GameController) controller;
  }

  /** Prompt for a players name. */
  public void promptForPlayerName() {
    String playerName =
        (String)
            JOptionPane.showInputDialog(
                frame, "Add a player", "Player", JOptionPane.PLAIN_MESSAGE, null, null, "");

    if (playerName != null && !playerName.isEmpty()) {
      controller.addPlayer(playerName);
    }

    //    int addMore = JOptionPane.showConfirmDialog(frame, "Add more players ?", "More players",
    // JOptionPane.YES_NO_OPTION);
    //    if( addMore == JOptionPane.NO_OPTION) {
    //      controller.startGame();
    //    }
  }

  /** Prompt user to flip cards. */
  public void promptForFlip() {
    JOptionPane.showConfirmDialog(frame, "Click to reveal cards", "And....", JOptionPane.OK_OPTION);
    controller.flipCards();
  }

  /** Prompt the user to battle again. */
  public void promptForNewGame() {
    int newGame =
        JOptionPane.showConfirmDialog(
            frame, "Play again ?", "Play again", JOptionPane.YES_NO_OPTION);
    if (newGame == JOptionPane.NO_OPTION) {
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
    frame.appendText(message);
  }
}
