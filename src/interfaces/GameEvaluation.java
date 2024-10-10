package interfaces;

import classes.lib.records.PlayersCard;
import interfaces.lib.players.Player;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/** Allow to evaluate a game winner. */
public interface GameEvaluation {

  /** Calculate the game winner. */
  @NotNull
  Player evaluateWinner(ArrayList<PlayersCard> playersCards);
}
