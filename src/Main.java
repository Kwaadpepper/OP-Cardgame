import Classes.Controllers.GameController;
import Classes.Deck;
import Classes.Views.GameView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to gard game ! \n");

        GameController gc = new GameController(new GameView(), new Deck());
        gc.run();
    }
}