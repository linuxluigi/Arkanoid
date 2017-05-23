package com.linuxluigi.edu.view;

import com.linuxluigi.edu.controller.MouseClick;
import com.linuxluigi.edu.controller.UpdatePlayerWithMouse;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * Created by fubu on 23.05.17.
 */
public class AddClickEvent {
    public static void addClickEvent (Scene scene) {
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new MouseClick());
    }
}