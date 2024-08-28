package Classes.Interfaces;

import Classes.Card;
import Classes.Player;
import org.jetbrains.annotations.NotNull;

/** Allow to evaluate a game winner */
public interface GameEvaluation {
    /** Reset participants list */
    void resetParticipants();

    /** Add a participant */
    void addParticipant(@NotNull Player player, @NotNull Card card);

    /** Calculate the game winner */
    @NotNull Player evaluateWinner();
}
