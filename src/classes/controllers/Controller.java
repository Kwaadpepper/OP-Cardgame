package classes.controllers;

import classes.views.View;
import interfaces.controllers.Runnable;

/** Base Controller. */
public abstract class Controller<T extends View> implements Runnable {

  /** The controller view. */
  protected final T view;

  Controller(T view) {
    this.view = view;
    view.setController(this);
  }
}
