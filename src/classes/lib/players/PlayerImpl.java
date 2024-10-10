package classes.lib.players;

import classes.Card;
import classes.PlayerHand;
import interfaces.lib.players.Player;
import org.jetbrains.annotations.Nullable;

/** A game player. */
public class PlayerImpl implements Player {

  /** The amount of game players. */
  static int playerCount = 0;

  final PlayerHand hand;

  /** The player ID. */
  private final int id;

  /** Le nom du joueur. */
  private final String name;

  /** Main constructor. */
  public PlayerImpl(String name) {
    this.name = name;
    hand = new PlayerHand();
    id = PlayerImpl.playerCount++;
  }

  @Override
  public void addCardToHand(Card card) {
    hand.addCard(card);
  }

  @Override
  public @Nullable Card getCard(int index) {
    return hand.getCard(index);
  }

  @Override
  public void removeCard(int index) {
    hand.removeCard(index);
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }
}
