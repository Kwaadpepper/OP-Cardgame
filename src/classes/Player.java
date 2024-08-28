package classes;

import org.jetbrains.annotations.Nullable;

/** A game player. */
public class Player {

  /** The amount of game players. */
  static int playerCount = 0;

  final PlayerHand hand;

  /** The player ID. */
  private final int id;

  /** Le nom du joueur. */
  private final String name;

  /** Main constructor. */
  public Player(String name) {
    this.name = name;
    hand = new PlayerHand();
    id = Player.playerCount++;
  }

  /** Add a card to players hand. */
  public void addCardToHand(Card card) {
    hand.addCard(card);
  }

  /** Get a card from the players hand. */
  public @Nullable Card getCard(int index) {
    return hand.getCard(index);
  }

  /** Remove a card from players hand. */
  public void removeCard(int index) {
    hand.removeCard(index);
  }

  /** Get the players ID. */
  public int getId() {
    return id;
  }

  /** Get the players name. */
  public String getName() {
    return name;
  }
}
