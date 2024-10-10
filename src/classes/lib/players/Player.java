package classes.lib.players;

import classes.Card;
import org.jetbrains.annotations.Nullable;

/** A game player. */
public interface Player {
  /** Add a card to players hand. */
  void addCardToHand(Card card);

  /** Get a card from the players hand. */
  @Nullable
  Card getCard(int index);

  /** Remove a card from players hand. */
  void removeCard(int index);

  /** Get the players ID. */
  int getId();

  /** Get the players name. */
  String getName();
}
