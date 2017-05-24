package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.view.DialogWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by fubu on 18.05.17.
 */
public class MenubarLevelSaveLevel implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        if (Controller.getModel().getLevelFile() == null) {
            Controller.getModel().setLevelFile(
                    DialogWindow.getSaveFile(Controller.getView().getScene())
            );
        }

        Controller.getModel().saveLevel();
    }
}
