package com.linuxluigi.edu;

import com.linuxluigi.edu.controller.Controller;
import com.linuxluigi.edu.model.Model;
import com.linuxluigi.edu.view.MainFrame;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by fubu on 17.05.17.
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        double startWidth = 800;
        double startHeight = 600;

        // Model
        Model model = new Model(primaryStage, startWidth, startHeight);

        MainFrame view = new MainFrame(startWidth, startHeight);

        // controller
        Controller controller = new Controller(model, view);
        controller.show();
    }


}