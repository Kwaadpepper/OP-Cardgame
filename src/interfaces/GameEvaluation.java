package interfaces;

import classes.Player;
import classes.lib.records.PlayersCard;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/** Allow to evaluate a game winner. */
public interface GameEvaluation {

  /** Calculate the game winner. */
  @NotNull
  Player evaluateWinner(ArrayList<PlayersCard> playersCards);
}
