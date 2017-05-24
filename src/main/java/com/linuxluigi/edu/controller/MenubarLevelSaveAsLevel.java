package com.linuxluigi.edu.controller;

import com.linuxluigi.edu.controller.Controller;
import com.linuxluigi.edu.view.DialogWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by fubu on 18.05.17.
 */
public class MenubarLevelSaveAsLevel implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Controller.getModel().setLevelFile(
                DialogWindow.getSaveFile(Controller.getView().getScene())
        );

        Controller.getModel().saveLevel();
    }
}
