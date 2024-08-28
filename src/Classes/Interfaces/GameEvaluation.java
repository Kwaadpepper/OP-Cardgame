package Classes.Interfaces;

import Classes.Lib.Records.PlayersCard;
import Classes.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/** Allow to evaluate a game winner */
public interface GameEvaluation {
    /** Calculate the game winner */
    @NotNull Player evaluateWinner(ArrayList<PlayersCard> playersCards);
}
