package classes.lib.players;

import classes.Card;
import org.jetbrains.annotations.Nullable;

/** Player that won a game. */
public class Winner implements Player {
  private final Player player;

  public Winner(Player player) {
    this.player = player;
  }

  public static Player of(Player player) {
    return new Winner(player);
  }

  @Override
  public void addCardToHand(final Card card) {
    player.addCardToHand(card);
  }

  @Override
  public @Nullable Card getCard(final int index) {
    return player.getCard(index);
  }

  @Override
  public void removeCard(final int index) {
    player.removeCard(index);
  }

  @Override
  public int getId() {
    return player.getId();
  }

  @Override
  public String getName() {
    return "*** %s ***".formatted(player.getName());
  }
}
