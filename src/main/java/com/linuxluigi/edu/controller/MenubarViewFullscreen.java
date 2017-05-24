package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by fubu on 18.05.17.
 */
public class MenubarViewFullscreen implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Controller.getView().fullscreenToggle();
        Controller.getModel().setFullscreen(!Controller.getModel().isFullscreen());

        if (Controller.getModel().isFullscreen() && !Controller.getModel().isEditmode()) {
            Controller.getView().disableMouseCursor();
        }
    }
}
