package Classes;

import Enums.Rank;
import Enums.Suit;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

/** A game deck with every card of the game */
public class Deck {

    /** The deck pile of cards */
    private Card[] pile = new Card[52];

    public Deck() {
        int index = 0;
        for(Rank color : Rank.values()) {
            for (Suit value : Suit.values()) {
                pile[index++] = new Card(value, color);
            }
        }
    }

    // --- METHODS ---

    /** Pick a card */
    public @Nullable Card pickCard() {
        if(pile.length < 1) {
            return null;
        }
        final Card output = pile[0];
        pile = ArrayUtils.remove(pile, 0);
        return output;
    }

    /** Return a card below the pile */
    public void returnCard(@NotNull Card card) {
        pile = ArrayUtils.add(pile, card);
    }

    /** Shuffle the deck */
    public void shuffle() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        ArrayUtils.shuffle(pile, rand);
    }
}
