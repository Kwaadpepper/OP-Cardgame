import classes.controllers.GameController;
import classes.factories.DeckFactoryImpl;
import classes.lib.games.BasicGameEvaluation;
import classes.views.CommandLineView;
import enums.DeckType;
import interfaces.Deck;
import interfaces.GameEvaluation;
import interfaces.factories.DeckFactory;
import interfaces.views.GameViewable;

/** Main classe for this program. */
public class Main {

  /** main function for this program. */
  public static void main(String[] args) {
    System.out.println("Welcome to gard game ! \n");

    DeckFactory factory = new DeckFactoryImpl();

    // GameViewable view = new SwingView();
    GameViewable view = new CommandLineView();
    Deck deck = factory.produceDeckOfType(DeckType.DECK_WITH_32);
    GameEvaluation gameEvaluator = new BasicGameEvaluation();

    GameController gc = new GameController(view, deck, gameEvaluator);
    gc.run();
  }
}
