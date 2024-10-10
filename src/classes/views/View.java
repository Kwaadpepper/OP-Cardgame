package classes.views;

import interfaces.views.GameViewable;

/** Base View. */
public abstract class View implements GameViewable {

  /** Format the players info to display. */
  protected String formatPlayerInfo(int playerId, String playerName) {
    return "[%d][%s]".formatted(playerId, playerName);
  }
}
