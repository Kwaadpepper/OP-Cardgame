package Classes;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/** La main d'un joueur contenant ses cartes */
public class PlayerHand {

    final private ArrayList<Card> cards;

    PlayerHand() {
        cards = new ArrayList<>();
    }

    // --- METHODS ---

    /** Add a card to the hand */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /** Remove a card at index */
    public @Nullable Card getCard(int index) {
        if(cards.isEmpty()) {
            return null;
        }
        return cards.get(index);
    }

    /** Remove a card of hand */
    public void removeCard(int index) {
        if (index < 0 || index >= cards.size()) {
            /* Out of bond */
            return;
        }
        cards.remove(index);
    }
}
