package classes.views;

import classes.controllers.Controller;
import interfaces.views.GameViewable;

/** Base View. */
public abstract class View implements GameViewable {

  /** The view controller. */
  Controller controller;

  /** Set the view controller. */
  public abstract void setController(Controller controller);
}
