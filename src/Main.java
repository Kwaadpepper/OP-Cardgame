import Classes.Controllers.GameController;
import Classes.Deck;
import Classes.Interfaces.GameEvaluation;
import Classes.Lib.Games.BasicGameEvaluation;
import Classes.Views.GameView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to gard game ! \n");

        GameEvaluation gameEvaluator = new BasicGameEvaluation();
        GameController gc = new GameController(new GameView(), new Deck(), gameEvaluator);
        gc.run();
    }
}