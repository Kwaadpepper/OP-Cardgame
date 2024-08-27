package Classes.Controllers;

import Classes.Views.View;
import Interfaces.Controllers.Runnable;

public abstract class Controller<T extends View> implements Runnable {

    /** The controller view */
    protected T view;

    Controller(T view) {
        this.view = view;
        view.setController(this);
    }
}
