package com.linuxluigi.edu.view;/**
 * Created by fubu on 17.05.17.
 */

import com.linuxluigi.edu.model.board.Board;
import com.linuxluigi.edu.model.board.Stone;
import com.linuxluigi.edu.model.gameObject.Ball;
import com.linuxluigi.edu.model.gameObject.PlayerBare;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.awt.*;
import java.util.*;
import java.util.List;

public class MainFrame {

    private Scene scene;
    private MenuBar menuBar;
    private BorderPane borderPane;
    private Stage primaryStage;
    private HBox editBox;
    private Pane pane;
    private Group group = new Group();

    // UserInterface
    private Label score;
    private Label live;
    private Label gameMessage = new Label();

    // EditDock
    private final ColorPicker colorPicker = new ColorPicker();
    private TextField pointsTextField;
    private CheckBox visibleCheckbox;
    private CheckBox undestroyableCheckBox;

    // Game Objects
    private Group stonesRectangle = new Group();
    private Rectangle playerBare;
    private java.util.List<Rectangle> stones = new ArrayList<Rectangle>();
    private Ellipse ball;

    public MainFrame(double startWidth, double startHeight) {
        this.borderPane = new BorderPane();
        this.scene = new Scene(this.borderPane, startWidth, startHeight);

        // set boarder top
        setMenuBar();
        this.borderPane.setTop(this.menuBar);

        // set border bottom
        setEditBox();
        // this.borderPane.setBottom(this.editBox);

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

        Menu selectLevelMenu = new Menu("Select Level", new ImageView("/fontAwesome/16/font-awesome_4-7-0_globe_16_0_f39c12_none.png"));
        selectLevelMenu.getItems().addAll(
                new MenuItem("Rainbow"),
                new MenuItem("HardCore"),
                new MenuItem("Easy")
        );

        MenuItem openMenuItem = new MenuItem("Open", new ImageView("/fontAwesome/16/font-awesome_4-7-0_folder-open_16_0_f39c12_none.png"));
        openMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+o"));

        MenuItem saveMenuItem = new MenuItem("Save", new ImageView("/fontAwesome/16/font-awesome_4-7-0_floppy-o_16_0_f39c12_none.png"));
        saveMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+s"));

        MenuItem saveAsMenuItem = new MenuItem("Save as", new ImageView("/fontAwesome/16/font-awesome_4-7-0_floppy-o_16_0_f39c12_none.png"));
        saveAsMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+shift+s"));

        MenuItem exitMenuItem = new MenuItem("Exit", new ImageView("/fontAwesome/16/font-awesome_4-7-0_times_16_0_f39c12_none.png"));

        fileMenu.getItems().addAll(newMenuItem, selectLevelMenu, openMenuItem, saveMenuItem, saveAsMenuItem,
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
        this.pane = new Pane(this.group, this.stonesRectangle);
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
        this.colorPicker.setValue(Color.RED);

        // Block Points
        final Text pointsLabel = new Text("Block Points:");
        this.pointsTextField = new TextField("100");
        // check for numbers only
        this.pointsTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("\\d*")) {
                    int value = Integer.parseInt(newValue);
                } else {
                    pointsTextField.setText(oldValue);
                }
            }
        });

        // Visible
        this.visibleCheckbox = new CheckBox();
        this.visibleCheckbox.setText("Visible");
        this.visibleCheckbox.setSelected(true);

        // Undestroyable
        this.undestroyableCheckBox = new CheckBox("Second");
        this.undestroyableCheckBox.setText("Undestroyable");

        this.editBox.getChildren().addAll(
                this.colorPicker,
                pointsLabel,
                this.pointsTextField,
                this.visibleCheckbox,
                this.undestroyableCheckBox
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
        if (this.primaryStage.isFullScreen()) {
            enableMouseCursor();
        } else {
            this.borderPane.setTop(null);
        }

        this.primaryStage.setFullScreen(!this.primaryStage.isFullScreen());
    }

    public void toggleEditBox() {
        if (this.borderPane.getBottom() != null) {
            this.borderPane.setBottom(null);

            // make Cursor & player invisible
            disableMouseCursor();
            this.playerBare.setVisible(true);
        } else {
            this.borderPane.setBottom(this.editBox);

            // make Cursor & player invisible
            enableMouseCursor();
            this.playerBare.setVisible(false);
        }
    }

    /**
     * Init game with new Level, Ball, Lives & Player
     *
     * @param playerBare
     */
    public void initGame(PlayerBare playerBare, Board board, Ball ball) {

        // Playerbare
        this.playerBare = new Rectangle(playerBare.getRelativWidth(), playerBare.getRelativHeight());
        this.playerBare.setX(playerBare.getRelativPositionX());
        this.playerBare.setY(playerBare.getRelativPositionY());
        this.playerBare.setFill(playerBare.getColor());
        this.playerBare.setStroke(Color.BLACK);
        this.group.getChildren().add(this.playerBare); //add obect to the group

        // Ball
        this.ball = new Ellipse();
        this.ball.setStroke(Color.BLACK);
        this.ball.setFill(Color.BLUEVIOLET);
        this.group.getChildren().add(this.ball);

        // Stones
        for (Stone stone : board.getStones()) {
            Rectangle stoneRectangle = new Rectangle();
            stoneRectangle.setX(stone.getRelativePositionX());
            stoneRectangle.setY(stone.getRelativePositionY());
            stoneRectangle.setWidth(stone.getRelativeWidth());
            stoneRectangle.setHeight(stone.getRelativeHeight());
            stoneRectangle.setFill(Color.valueOf(stone.getColor()));
            stoneRectangle.setFill(Color.valueOf("#ffffff"));
            stoneRectangle.setVisible(stone.isVisible());
            stoneRectangle.setStroke(Color.BLACK);
            this.stones.add(stoneRectangle);
            this.stonesRectangle.getChildren().add(stoneRectangle); //add obect to the group
        }

        // UserInterface
        this.live = new Label();
        this.live.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        this.stonesRectangle.getChildren().add(this.live);

        this.score = new Label();
        this.score.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        this.score.relocate(0, 0);

        this.stonesRectangle.getChildren().add(this.score);
        this.stonesRectangle.getChildren().add(this.gameMessage);
    }

    public void updateAllObjects(PlayerBare playerBare, Board board, int lives, int score, Ball ball) {
        // playerBare
        this.playerBare.setWidth(playerBare.getRelativWidth());
        this.playerBare.setHeight(playerBare.getRelativHeight());
        this.playerBare.setX(playerBare.getRelativPositionX());
        this.playerBare.setY(playerBare.getRelativPositionY());
        this.playerBare.setFill(playerBare.getColor());

        // Stones
        List<Stone> oldStones = board.getStones();

        for (int i = 0; i < this.stones.size(); i++) {
            stones.get(i).setFill(Color.valueOf(oldStones.get(i).getColor()));
            stones.get(i).setVisible(oldStones.get(i).isVisible());
            stones.get(i).setX(oldStones.get(i).getRelativePositionX());
            stones.get(i).setY(oldStones.get(i).getRelativePositionY());
            stones.get(i).setWidth(oldStones.get(i).getRelativeWidth());
            stones.get(i).setHeight(oldStones.get(i).getRelativeHeight());
        }

        // UserInterface
        double labelWidth = 150;
        double positionX = getPaneWidth() - labelWidth;
        this.live.relocate(positionX, 0);
        this.live.setText("Live: " + lives);
        this.score.setText("Score: " + score);
        this.gameMessage.relocate(getPaneWidth() / 2 - 150, getPaneWidth() / 2 - 70);

        // Ball
        this.ball.setCenterX(ball.getRelativeCenterX());
        this.ball.setCenterY(ball.getRelativeCenterY());
        this.ball.setRadiusX(ball.getRelativRadius());
        this.ball.setRadiusY(ball.getRelativRadius());
    }

    public void disableMouseCursor() {
        this.scene.setCursor(Cursor.NONE);
    }

    public void enableMouseCursor() {
        this.scene.setCursor(Cursor.DEFAULT);
    }

    public void setMousePosition(double positionX, double positionY) {
        Platform.runLater(() -> {
            try {
                Robot robot = new Robot();
                robot.mouseMove((int) positionX, (int) positionY);

            } catch (AWTException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Return a Stone with the value of the EditDock
     *
     * @return Stone object
     */
    public Stone getEditStone() {

        int points;

        if (this.pointsTextField.getText().equals("")) {
            points = 0;
        } else {
            points = Integer.parseInt(this.pointsTextField.getText());
        }

        Stone stone = new Stone(
                this.colorPicker.getValue().toString(),
                points,
                this.visibleCheckbox.isSelected(),
                this.undestroyableCheckBox.isSelected()
        );
        return stone;
    }

    public void setGameMessage(String message) {

        this.gameMessage.setFont(Font.font("Amble CN", FontWeight.BOLD, 50));
        this.gameMessage.setTextFill(Color.BLUE);
        this.gameMessage.setText(message);

    }

    public String getGameMessage() {
        return gameMessage.getText();
    }

    public boolean isToolbarActivat() {
        if (this.borderPane.getTop() != null) {
            return true;
        } else {
            return false;
        }
    }
}
