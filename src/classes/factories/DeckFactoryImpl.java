package classes.factories;

import classes.Card;
import classes.Deck32Cards;
import classes.Deck52Cards;
import enums.DeckType;
import enums.Rank;
import enums.Suit;
import interfaces.Deck;
import interfaces.factories.DeckFactory;
import java.util.Arrays;

/** Produces decks of 52 cards. */
public class DeckFactoryImpl implements DeckFactory {

  @Override
  public Deck produceDeckOfType(final DeckType type) {
    return switch (type) {
      case DeckType.DECK_WITH_52 -> produce52Cards();
      case DeckType.DECK_WITH_32 -> produce32Cards();
    };
  }

  private Deck produce52Cards() {
    final var pileOfCards = new Card[52];
    int index = 0;
    for (Suit value : Suit.values()) {
      for (Rank color : Rank.values()) {
        pileOfCards[index++] = new Card(value, color);
      }
    }

    return new Deck52Cards(pileOfCards);
  }

  private Deck produce32Cards() {
    final var pileOfCards = new Card[32];
    int index = 0;
    for (Suit value : Suit.values()) {
      for (Rank color : Arrays.stream(Rank.values()).filter(suit -> suit.value() >= 7).toList()) {
        pileOfCards[index++] = new Card(value, color);
      }
    }

    return new Deck32Cards(pileOfCards);
  }
}
