package interfaces;

import classes.Card;

/** A deck of cards to play with. */
public interface Deck {
  /** Pick a card. */
  Card pickCard();

  /** Return a card below the pile. */
  void returnCard(Card card);

  /** Shuffle the deck. */
  void shuffle();
}
