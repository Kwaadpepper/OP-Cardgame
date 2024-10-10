package classes.views;

import classes.controllers.Controller;
import interfaces.views.GameViewable;
import java.util.HashSet;
import java.util.Set;

/** Manage multiple views simultaneously. */
public class CompositeGameViewable implements interfaces.views.GameViewable {
  private final Set<interfaces.views.GameViewable> viewable;

  public CompositeGameViewable(Set<interfaces.views.GameViewable> viewable) {
    this.viewable = new HashSet<>(viewable);
  }

  @Override
  public void setController(final Controller controller) {
    viewable.forEach(gameViewable -> gameViewable.setController(controller));
  }

  @Override
  public void promptForPlayerName() {
    viewable.forEach(GameViewable::promptForPlayerName);
  }

  @Override
  public void promptForFlip() {
    viewable.forEach(GameViewable::promptForFlip);
  }

  @Override
  public void promptForNewGame() {
    viewable.forEach(GameViewable::promptForNewGame);
  }

  @Override
  public void showWinner(final String playerName) {
    viewable.forEach(gameViewable -> gameViewable.showWinner(playerName));
  }

  @Override
  public void showPlayerName(final int playerId, final String playerName) {
    viewable.forEach(gameViewable -> gameViewable.showPlayerName(playerId, playerName));
  }

  @Override
  public void showPlayerCardFacedDown(final int playerId, final String playerName) {
    viewable.forEach(gameViewable -> gameViewable.showPlayerCardFacedDown(playerId, playerName));
  }

  @Override
  public void showPlayerCardFacedUp(
      final int playerId, final String playerName, final String rank, final String suit) {
    viewable.forEach(
        gameViewable -> gameViewable.showPlayerCardFacedUp(playerId, playerName, rank, suit));
  }

  @Override
  public void printMessage(final String message) {
    viewable.forEach(gameViewable -> gameViewable.printMessage(message));
  }
}
