package interfaces;

import classes.Card;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** A deck of cards to play with. */
public interface Deck {
  /** Pick a card. */
  @Nullable
  Card pickCard();

  /** Return a card below the pile. */
  void returnCard(@NotNull Card card);

  /** Shuffle the deck. */
  void shuffle();
}
