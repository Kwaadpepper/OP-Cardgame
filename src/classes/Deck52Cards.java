package classes;

import interfaces.Deck;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** A game deck with 52 playing cards. */
public class Deck52Cards implements Deck {

  /** The deck pile of cards. */
  private Card[] pile;

  /** Main constructor. */
  public Deck52Cards(Card[] pile) {
    this.pile = pile;
  }

  // --- METHODS ---

  /** Pick a card. */
  @Override
  public @Nullable Card pickCard() {
    if (pile.length < 1) {
      return null;
    }
    final Card output = pile[0];
    pile = ArrayUtils.remove(pile, 0);
    return output;
  }

  /** Return a card below the pile. */
  @Override
  public void returnCard(@NotNull Card card) {
    pile = ArrayUtils.add(pile, card);
  }

  /** Shuffle the deck. */
  @Override
  public void shuffle() {
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());
    ArrayUtils.shuffle(pile, rand);
  }
}
