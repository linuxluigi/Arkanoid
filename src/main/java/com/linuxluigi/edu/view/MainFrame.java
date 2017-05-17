package com.linuxluigi.edu.view;/**
 * Created by fubu on 17.05.17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFrame extends Application {

    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ArkanoidFx");
        BorderPane borderPane = new BorderPane();
        this.scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }

    public void show() {
        launch();
    }
}
