package com.linuxluigi.edu.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by fubu on 19.05.17.
 */
public class UpdatePlayerWithMouse implements EventHandler<MouseEvent>{

    @Override
    public void handle(MouseEvent event) {
        Controller.getModel().setPlayerCenter(event.getX(), event.getY());
        Controller.updateViewObjects();
    }
}