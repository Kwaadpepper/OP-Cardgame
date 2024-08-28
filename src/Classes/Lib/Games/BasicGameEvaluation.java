package Classes.Lib.Games;

import Classes.Card;
import Classes.Interfaces.GameEvaluation;
import Classes.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BasicGameEvaluation implements GameEvaluation {

    private final ArrayList<PlayersCard> tablePlayersCards = new ArrayList<>(4);

    private record PlayersCard(Player player, Card card) {}

    public void resetParticipants() {
        while (tablePlayersCards.size() > 1) {
            tablePlayersCards.removeFirst();
        }
    }

    public void addParticipant(@NotNull Player player, @NotNull Card card) {
        tablePlayersCards.add(new PlayersCard(player, player.getCard(0)));
    }

    public @NotNull Player evaluateWinner() {
        /* Sort table cards : Compare values */
        tablePlayersCards.sort((PlayersCard a, PlayersCard b) -> {
            int cmp = b.card.getValue().value() - a.card.getValue().value();
            /* If ranks are equals */
            if (cmp == 0) {
                /* then sort by colors */
                return b.card.getColor().value() - a.card.getColor().value();
            }
            return cmp;
        });

        return tablePlayersCards.getFirst().player;
    }
}
