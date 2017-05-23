package com.linuxluigi.edu.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static com.linuxluigi.edu.model.StaticVar.absoluteHeight;
import static com.linuxluigi.edu.model.StaticVar.playerAreaHeight;
import static com.linuxluigi.edu.model.StaticVar.relativeHeight;

/**
 * Created by fubu on 19.05.17.
 */
public class UpdatePlayerWithMouse implements EventHandler<MouseEvent>{

    @Override
    public void handle(MouseEvent event) {
        Controller.getModel().setPlayerCenter(event.getX(), event.getY());
        Controller.updateViewObjects();

        // If the fullscreen mode is activated && editmode is off --> do not allow the mouse to go outside of the player area
        if (Controller.getModel().isFullscreen() && !Controller.getModel().isEditmode()) {
            // top
            double absoluteHeight = absoluteHeight(event.getY());

            if (absoluteHeight < playerAreaHeight) {
                Controller.getView().setMousePosition(event.getX(), relativeHeight(playerAreaHeight));
            }

            // bottom
            double maxBottom = Controller.getView().getPaneHeight() - 20;
            if (event.getY() > maxBottom) {
                Controller.getView().setMousePosition(event.getX(), maxBottom);
            }
        }
    }
}