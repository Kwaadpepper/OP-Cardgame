package interfaces;

import classes.lib.records.PlayersCard;
import interfaces.lib.players.Player;
import java.util.ArrayList;

/** Allow to evaluate a game winner. */
public interface GameEvaluation {

  /** Calculate the game winner. */
  Player evaluateWinner(ArrayList<PlayersCard> playersCards);
}
