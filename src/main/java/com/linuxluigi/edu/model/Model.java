package com.linuxluigi.edu.model;

import com.linuxluigi.edu.model.board.Board;
import com.linuxluigi.edu.model.gameObject.Ball;
import com.linuxluigi.edu.model.gameObject.PlayerBare;
import com.linuxluigi.edu.model.level.Level;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

import static com.linuxluigi.edu.model.StaticVar.defaultHeight;
import static com.linuxluigi.edu.model.StaticVar.defaultWidth;

/**
 * Created by fubu on 17.05.17.
 * Main Model
 */
public class Model {
    // active board on witch the user play
    private Board board;

    private Stage primaryStage = null;

    // Level File
    private File levelFile;
    private File resourceLevelFile;

    // Game
    private int lives = 3;  // 3 == Default live at start
    private int points = 0;

    // Objects
    private PlayerBare playerBare;
    private Ball ball;

    // GameModes
    private boolean fullscreen = false;
    private boolean editmode = false;

    public Model(Stage primaryStage, double startWidth, double startHeight) {
        this.primaryStage = primaryStage;

        try
        {
            loadLevelFromResources("Rainbow");
        }
        catch (Exception e)
        {
            this.board = new Board();
        }


        setWindowWidth(startWidth);
        setWindowHeight(startHeight);
        restartGame();
        init();
    }

    private void init() {
        this.playerBare = new PlayerBare();
    }

    public PlayerBare getPlayerBare() {
        return playerBare;
    }

    public void setPlayerBare(PlayerBare playerBare) {
        this.playerBare = playerBare;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setWindowWidth(double width) {
        StaticVar.setWindowWidth(width);
    }

    public void setWindowHeight(double height) {
        StaticVar.setWindowHeigh(height);
    }

    public void setPlayerCenter(double width, double height) {
        playerBare.setCenter(width, height);
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public boolean isEditmode() {
        return editmode;
    }

    public void setEditmode(boolean editmode) {
        this.editmode = editmode;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void newBall() {
        this.ball = new Ball(defaultWidth / 2, defaultHeight - 260, 30);
    }

    public File getLevelFile() {
        return levelFile;
    }

    public void setLevelFile(File levelFile) {
        this.levelFile = levelFile;
    }

    public void loadLevel() {
        this.board = Level.loadLevel(this.levelFile);
        this.points = 0;
        this.lives = 3;
        newBall();
    }

    public void saveLevel() {
        Level.saveLevel(this.levelFile, this.board);
    }

    public void loadLevelFromResources(String levelFile) {
        this.levelFile = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        this.resourceLevelFile = new File(classloader.getResource("level/" + levelFile + ".json").getFile());
        this.board = Level.loadLevel(this.resourceLevelFile);
        restartGame();
    }

    /**
     * Complete restart of the game
     */
    public void restartGame() {
        if (this.levelFile != null) {
            this.board = Level.loadLevel(this.levelFile);
        } else {
            this.board = Level.loadLevel(this.resourceLevelFile);
        }
        this.points = 0;
        this.lives = 3;
        newBall();
    }
}
