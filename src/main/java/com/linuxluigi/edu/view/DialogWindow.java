package com.linuxluigi.edu.view;

import com.linuxluigi.edu.controller.Controller;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by fubu on 24.05.17.
 */
public class DialogWindow {
    public static File getSaveFile (Scene scene) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Level");

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Json", "*.json"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        return fileChooser.showSaveDialog(scene.getWindow());
    }

    public static File getLoadFile (Scene scene) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Level");

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Json", "*.json"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        return fileChooser.showOpenDialog(scene.getWindow());
    }
}
