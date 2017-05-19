package com.linuxluigi.edu.model;

import com.linuxluigi.edu.model.board.Board;
import com.linuxluigi.edu.model.game.Game;
import com.linuxluigi.edu.model.game.Highscore;
import com.linuxluigi.edu.model.gameObject.PlayerBare;
import com.linuxluigi.edu.model.level.Level;
import javafx.stage.Stage;

/**
 * Created by fubu on 17.05.17.
 * Main Model
 */
public class Model {
    private Board board;
    private Game game;
    private Highscore highscore;
    private Level level;
    private Stage primaryStage = null;

    private PlayerBare playerBare;

    public Model(Stage primaryStage, double startWidth, double startHeight) {
        this.primaryStage = primaryStage;
        this.board = new Board();
        this.game = new Game();
        this.highscore = new Highscore();
        this.level = new Level();
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Highscore getHighscore() {
        return highscore;
    }

    public void setHighscore(Highscore highscore) {
        this.highscore = highscore;
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
}
