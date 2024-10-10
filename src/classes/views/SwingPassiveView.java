package classes.views;

import frames.GameFrame;
import interfaces.views.GameViewable;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/** For the game to be viewed in a Swing Interface. */
public class SwingPassiveView extends View implements GameViewable {

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
    printMessage("Waiting for player name ...");
  }

  @Override
  public void promptForFlip() {
    printMessage("Waiting for flipping cards ...");
  }

  @Override
  public void promptForNewGame() {
    printMessage("Waiting for next step ...");
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
