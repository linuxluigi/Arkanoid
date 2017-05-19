package com.linuxluigi.edu.view;/**
 * Created by fubu on 17.05.17.
 */

import com.linuxluigi.edu.model.gameObject.PlayerBare;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainFrame {

    private Scene scene;
    private MenuBar menuBar;
    private BorderPane borderPane;
    private Stage primaryStage;
    private HBox editBox;
    private Pane pane;
    private Group group = new Group();

    // Game Objects
    private Rectangle playerBare;

    public MainFrame(double startWidth, double startHeight) {
        this.borderPane = new BorderPane();
        this.scene = new Scene(this.borderPane, startWidth, startHeight);

        // set boarder top
        setMenuBar();
        this.borderPane.setTop(this.menuBar);

        // set border bottom
        setEditBox();
        this.borderPane.setBottom(this.editBox);

        // set boarder center
        setPane();
        this.borderPane.setCenter(this.pane);
    }

    private void setMenuBar() {
        // tutorial http://www.java2s.com/Tutorials/Java/JavaFX/0560__JavaFX_Menu.htm
        this.menuBar = new MenuBar();

        // File menu - new, save, exit
        Menu fileMenu = new Menu("Level", new ImageView("/fontAwesome/16/font-awesome_4-7-0_globe_16_0_f39c12_none.png"));

        MenuItem newMenuItem = new MenuItem("New", new ImageView("/fontAwesome/16/font-awesome_4-7-0_file_16_0_f39c12_none.png"));
        newMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+n"));

        MenuItem openMenuItem = new MenuItem("Open", new ImageView("/fontAwesome/16/font-awesome_4-7-0_folder-open_16_0_f39c12_none.png"));
        openMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+o"));

        MenuItem saveMenuItem = new MenuItem("Save", new ImageView("/fontAwesome/16/font-awesome_4-7-0_floppy-o_16_0_f39c12_none.png"));
        saveMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+s"));

        MenuItem saveAsMenuItem = new MenuItem("Save as", new ImageView("/fontAwesome/16/font-awesome_4-7-0_floppy-o_16_0_f39c12_none.png"));
        saveAsMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+shift+s"));

        MenuItem exitMenuItem = new MenuItem("Exit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_times_16_0_f39c12_none.png"));

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        // Edit Menu
        Menu editMenu = new Menu("Edit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_edit_16_0_f39c12_none.png"));

        MenuItem levelEditMenuItem = new MenuItem("Level Edit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_pencil_16_0_f39c12_none.png"));
        levelEditMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+e"));

        editMenu.getItems().addAll(levelEditMenuItem);

        // View Menu
        Menu viewMenu = new Menu("View", new ImageView("/fontAwesome/16/font-awesome_4-7-0_window-maximize_16_0_f39c12_none.png"));

        MenuItem fullscreenMenuIten = new MenuItem("MenubarViewFullscreen", new ImageView("/fontAwesome/16/font-awesome_4-7-0_arrows-alt_16_0_f39c12_none.png"));
        fullscreenMenuIten.setAccelerator(KeyCombination.keyCombination("shortcut+f"));

        MenuItem toolbarMenuIten = new MenuItem("Disable Toolbar", new ImageView("/fontAwesome/16/font-awesome_4-7-0_bars_16_0_f39c12_none.png"));
        toolbarMenuIten.setAccelerator(KeyCombination.keyCombination("shortcut+t"));

        viewMenu.getItems().addAll(fullscreenMenuIten, toolbarMenuIten);

        this.menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu);
    }

    private void setPane() {
        //create a pane for a group with all moving objects
        this.pane = new Pane(group);
        this.pane.setStyle(
                "-fx-background-image: url('/background/pixabay-com-hintergrund-textur-material-grafik-1988181.jpg'); " +
                        "-fx-background-repeat: stretch; " +
                        "-fx-background-position: center center;" +
                        "-fx-background-size: cover;"
        );
    }

    private void setEditBox() {
        this.editBox = new HBox();
        this.editBox.setPadding(new Insets(15, 12, 15, 12));
        this.editBox.setSpacing(10);

        // Color Picker
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);

        // Block Points
        final Text pointsLabel = new Text("Block Points:");
        TextField pointsTextField = new TextField ();
        // check for numbers only
        pointsTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("\\d*")) {
                    int value = Integer.parseInt(newValue);
                } else {
                    pointsTextField.setText(oldValue);
                }
            }
        });

        // Visible
        CheckBox visibleCheckbox = new CheckBox();
        visibleCheckbox.setText("Visible");
        visibleCheckbox.setSelected(true);

        // Undestroyable
        CheckBox undestroyableCheckBox = new CheckBox("Second");
        undestroyableCheckBox.setText("Undestroyable");

        this.editBox.getChildren().addAll(
                colorPicker,
                pointsLabel,
                pointsTextField,
                visibleCheckbox,
                undestroyableCheckBox
        );
    }

    /**
     * Make the Toolbar in / visible
     */
    public void toogleToolbarVisibility() {
        if (this.borderPane.getTop() != null) {
            this.borderPane.setTop(null);
        } else {
            this.borderPane.setTop(this.menuBar);
        }
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Scene getScene() {
        return scene;
    }

    public void show(Stage stage) {
        this.primaryStage = stage;
        stage.setTitle("Arkanoid XD");
        stage.setScene(scene);
        stage.show();
    }

    public double getPaneWidth() {
        return pane.widthProperty().get();
    }

    public double getPaneHeight() {
        return pane.heightProperty().get();
    }

    public void fullscreenToggle() {
        this.primaryStage.setFullScreen(!this.primaryStage.isFullScreen());
    }

    public void toggleEditBox() {
        if (this.borderPane.getBottom() != null) {
            this.borderPane.setBottom(null);

            // make Cursor & player invisible
            this.scene.setCursor(Cursor.NONE);
            this.playerBare.setVisible(true);
        } else {
            this.borderPane.setBottom(this.editBox);

            // make Cursor & player invisible
            this.scene.setCursor(Cursor.DEFAULT);
            this.playerBare.setVisible(false);
        }
    }

    /**
     * Init game with new Level, Ball, Lives & Player
     * @param playerBare
     */
    public void initGame (PlayerBare playerBare) {
        this.playerBare = new Rectangle(playerBare.getRelativWidth(), playerBare.getRelativHeight());
        this.playerBare.setX(playerBare.getRelativPositionX());
        this.playerBare.setY(playerBare.getRelativPositionY());
        this.playerBare.setFill(playerBare.getColor());
        this.group.getChildren().add(this.playerBare); //add obect to the group
    }

    public void updateAllObjects(PlayerBare playerBare) {
        // playerBare
        this.playerBare.setWidth(playerBare.getRelativWidth());
        this.playerBare.setHeight(playerBare.getRelativHeight());
        this.playerBare.setX(playerBare.getRelativPositionX());
        this.playerBare.setY(playerBare.getRelativPositionY());
        this.playerBare.setFill(playerBare.getColor());
    }

    private void setAnimationTimer() {
        new AnimationTimer() { //animate all circles
            @Override
            public void handle(long now) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }
}
