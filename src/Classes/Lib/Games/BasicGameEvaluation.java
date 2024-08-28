package Classes.Lib.Games;

import Classes.Interfaces.GameEvaluation;
import Classes.Lib.Records.PlayersCard;
import Classes.Player;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class BasicGameEvaluation implements GameEvaluation {
    public @NotNull Player evaluateWinner(ArrayList<PlayersCard> playersCards) {
        final ArrayList<PlayersCard> tablePlayersCards = new ArrayList<>(playersCards);

        /* Sort table cards : Compare values */
        tablePlayersCards.sort((PlayersCard a, PlayersCard b) -> {
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
