package classes.views;

import frames.GameFrame;
import interfaces.views.GameViewable;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** For the game to be viewed in a Swing Interface. */
public class SwingView extends View implements GameViewable {

  /** View frame. */
  GameFrame frame;

  @Override
  public void createAndDisplayGui() {
    // create main frame
    frame = new GameFrame("MVC-SOLID-Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);

    // display vertically
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    frame.setVisible(true);
  }

  @Override
  public void promptForPlayerName() {
    String playerName =
        (String)
            JOptionPane.showInputDialog(
                frame, "Add a player", "Player", JOptionPane.PLAIN_MESSAGE, null, null, "");

    if (playerName != null && !playerName.isEmpty()) {
      controller.addPlayer(playerName);
    }
  }

  @Override
  public void promptForFlip() {
    JOptionPane.showConfirmDialog(
        frame, "Click to reveal cards", "And....", JOptionPane.DEFAULT_OPTION);
    controller.flipCards();
  }

  @Override
  public void promptForNewGame() {
    int newGame =
        JOptionPane.showConfirmDialog(
            frame, "Play again ?", "Play again", JOptionPane.YES_NO_OPTION);
    if (newGame == JOptionPane.NO_OPTION) {
      controller.closeGame();
      return;
    }
    controller.startGame();
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
    frame.appendText(message);
  }
}
