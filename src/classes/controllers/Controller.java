package classes.controllers;

import interfaces.controllers.Runnable;
import interfaces.views.GameViewable;

/** Base Controller. */
public abstract class Controller implements Runnable {

  /** The controller view. */
  protected final GameViewable view;

  Controller(GameViewable view) {
    this.view = view;
    view.setController(this);
  }
}
