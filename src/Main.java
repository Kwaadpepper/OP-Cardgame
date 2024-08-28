import classes.Deck;
import classes.controllers.GameController;
import classes.lib.games.BasicGameEvaluation;
import classes.views.CommandLineView;
import interfaces.GameEvaluation;

/** Main classe for this program. */
public class Main {

  /** main function for this program. */
  public static void main(String[] args) {
    System.out.println("Welcome to gard game ! \n");

    GameEvaluation gameEvaluator = new BasicGameEvaluation();
    GameController gc = new GameController(new CommandLineView(), new Deck(), gameEvaluator);
    gc.run();
  }
}
