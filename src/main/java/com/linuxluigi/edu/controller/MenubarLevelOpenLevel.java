package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.controller.Controller;
import com.linuxluigi.edu.view.DialogWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by fubu on 18.05.17.
 */
public class MenubarLevelOpenLevel implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {

        Controller.getModel().setLevelFile(
                DialogWindow.getLoadFile(Controller.getView().getScene())
        );

        Controller.getModel().loadLevel();
        Controller.updateViewObjects();
    }
}
