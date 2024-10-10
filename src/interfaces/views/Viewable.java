package interfaces.views;


import classes.controllers.GameController;

/** A view that can be display. */
public interface Viewable {

  /** Set the view controller. */
  void setController(GameController controller);

  /** Create and display Gui. */
  void createAndDisplayGui();
}
