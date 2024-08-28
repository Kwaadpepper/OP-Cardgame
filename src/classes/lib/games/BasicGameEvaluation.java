package classes.lib.games;

import classes.Player;
import classes.lib.records.PlayersCard;
import interfaces.GameEvaluation;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/** The most valued card wins, colors are valued using it enum order. */
public class BasicGameEvaluation implements GameEvaluation {

  /** Calculate the game winner. */
  public @NotNull Player evaluateWinner(ArrayList<PlayersCard> playersCards) {
    final ArrayList<PlayersCard> tablePlayersCards = new ArrayList<>(playersCards);

    /* Sort table cards : Compare values */
    tablePlayersCards.sort(
        (PlayersCard a, PlayersCard b) -> {
          int cmp = b.card().getValue().value() - a.card().getValue().value();
          /* If ranks are equals */
          if (cmp == 0) {
            /* then sort by colors */
            return b.card().getColor().value() - a.card().getColor().value();
          }
          return cmp;
        });

    return tablePlayersCards.getFirst().player();
  }
}
