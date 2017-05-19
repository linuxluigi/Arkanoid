package com.linuxluigi.edu.view;

import com.linuxluigi.edu.controller.UpdatePlayerWithMouse;
import javafx.scene.Scene;

/**
 * Created by fubu on 19.05.17.
 */
public class AddMouseHandler {
    public static void addMouseMovemntEvent (Scene scene) {
        scene.setOnMouseMoved(new UpdatePlayerWithMouse());
    }
}

