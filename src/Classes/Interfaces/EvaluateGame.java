package Classes.Interfaces;

import Classes.Card;
import Classes.Player;
import org.jetbrains.annotations.NotNull;

/** Allow to evaluate a game winner */
public interface EvaluateGame {
    /** Add a participant */
    public void addParticipant(@NotNull Player player, @NotNull Card card);

    /** Calculate the game winner */
    public @NotNull Player evaluateWinner();
}
