package classes.views;

import classes.controllers.GameController;
import interfaces.views.GameViewable;
import java.util.HashSet;
import java.util.Set;

/** Manage multiple views simultaneously. */
public class CompositeGameViewable extends View {
  private final Set<View> viewableSet;

  public CompositeGameViewable(Set<View> viewableSet) {
    this.viewableSet = new HashSet<>(viewableSet);
  }

  @Override
  public void setController(GameController controller) {
    viewableSet.forEach(viewable -> viewable.setController(controller));
  }

  @Override
  public void createAndDisplayGui() {
    viewableSet.forEach(View::createAndDisplayGui);
  }

  @Override
  public void promptForPlayerName() {
    viewableSet.forEach(GameViewable::promptForPlayerName);
  }

  @Override
  public void promptForFlip() {
    viewableSet.forEach(GameViewable::promptForFlip);
  }

  @Override
  public void promptForNewGame() {
    viewableSet.forEach(GameViewable::promptForNewGame);
  }

  @Override
  public void showWinner(final String playerName) {
    viewableSet.forEach(viewable -> viewable.showWinner(playerName));
  }

  @Override
  public void showPlayerName(final int playerId, final String playerName) {
    viewableSet.forEach(viewable -> viewable.showPlayerName(playerId, playerName));
  }

  @Override
  public void showPlayerCardFacedDown(final int playerId, final String playerName) {
    viewableSet.forEach(viewable -> viewable.showPlayerCardFacedDown(playerId, playerName));
  }

  @Override
  public void showPlayerCardFacedUp(
      final int playerId, final String playerName, final String rank, final String suit) {
    viewableSet.forEach(
        viewable -> viewable.showPlayerCardFacedUp(playerId, playerName, rank, suit));
  }

  @Override
  public void printMessage(final String message) {
    viewableSet.forEach(viewable -> viewable.printMessage(message));
  }
}
