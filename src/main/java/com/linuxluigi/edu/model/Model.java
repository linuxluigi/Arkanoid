package com.linuxluigi.edu.model;

import com.linuxluigi.edu.model.board.Board;
import com.linuxluigi.edu.model.gameObject.Ball;
import com.linuxluigi.edu.model.gameObject.PlayerBare;
import com.linuxluigi.edu.model.level.Level;
import javafx.stage.Stage;

import static com.linuxluigi.edu.model.StaticVar.defaultHeight;
import static com.linuxluigi.edu.model.StaticVar.defaultWidth;

/**
 * Created by fubu on 17.05.17.
 * Main Model
 */
public class Model {
    private Board board;
    private Level level;
    private Stage primaryStage = null;

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
        this.board = new Board();
        this.level = new Level();
        this.ball = new Ball(defaultWidth / 2, defaultHeight - 260, 30);
        setWindowWidth(startWidth);
        setWindowHeight(startHeight);
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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
}
