package com.linuxluigi.edu.view;

import com.linuxluigi.edu.controller.Controller;
import com.linuxluigi.edu.controller.WindowChangedHeight;
import com.linuxluigi.edu.controller.WindowChangedWidth;
import javafx.scene.Scene;

/**
 * Created by fubu on 19.05.17.
 */
public class AddWindowChangedSize {
    public static void addWindowChangedSize(Scene scene) {
        //set pane autoresisable
        scene.widthProperty().addListener(new WindowChangedWidth());
        scene.heightProperty().addListener(new WindowChangedHeight());
    }
}


