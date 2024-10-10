package classes.controllers;

import classes.views.View;
import interfaces.controllers.Runnable;

/** Base Controller. */
public abstract class Controller implements Runnable {

  /** The controller view. */
  protected final View view;

  Controller(View view) {
    this.view = view;
    view.createAndDisplayGui();
  }
}
