package classes.views;

import classes.controllers.GameController;
import interfaces.views.GameViewable;
import interfaces.views.Viewable;

/** Base View. */
public abstract class View implements Viewable, GameViewable {
  protected GameController controller;

  @Override
  public void setController(GameController controller) {
    this.controller = controller;
  }

  /** Format the players info to display. */
  protected String formatPlayerInfo(int playerId, String playerName) {
    return "[%d][%s]".formatted(playerId, playerName);
  }
}
