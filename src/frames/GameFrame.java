package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** Main view for the game. */
public class GameFrame extends JFrame {

  private JPanel panel;
  private JScrollPane scrollPane;
  private JTextArea textArea;

  public GameFrame(String title) {
    super(title);
    textArea.setSize(500, 500);
  }

  /** Add text. */
  public void appendText(String text) {
    textArea.append(text + "\n");
    textArea.setCaretPosition(textArea.getDocument().getLength());
  }
}
