package interfaces.factories;

import enums.DeckType;
import interfaces.Deck;

/** Generate decks. */
public interface DeckFactory {
  Deck produceDeckOfType(DeckType type);
}
