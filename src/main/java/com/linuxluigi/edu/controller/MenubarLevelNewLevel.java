package com.linuxluigi.edu.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by fubu on 18.05.17.
 */
public class MenubarLevelNewLevel implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Controller.getModel().restartGame();
        Controller.getView().setGameMessage("");
    }
}
