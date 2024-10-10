package classes;

import enums.Rank;
import enums.Suit;

/** A playing card. */
public class Card {
  /** La couleur de la carte. */
  private final Suit suit;

  /** La valeur de la carte. */
  private final Rank rank;

  /** Si la carte est face cachée. */
  private boolean hidden = true;

  public Card(Suit color, Rank value) {
    this.suit = color;
    this.rank = value;
  }

  // --- METHODS ---

  /** Flip the card. */
  public void flip() {
    this.hidden = !this.hidden;
  }

  /** Get the card value. */
  public Rank getValue() {
    return rank;
  }

  /** Get the card color. */
  public Suit getColor() {
    return suit;
  }
}
