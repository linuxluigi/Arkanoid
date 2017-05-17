package com.linuxluigi.edu.model;

import com.linuxluigi.edu.model.board.Board;
import com.linuxluigi.edu.model.game.Game;
import com.linuxluigi.edu.model.game.Highscore;
import com.linuxluigi.edu.model.level.Level;

/**
 * Created by fubu on 17.05.17.
 * Main Model
 */
public class Model {
    private Board board;
    private Game game;
    private Highscore highscore;
    private Level level;

    public Model() {
        this.board = new Board();
        this.game = new Game();
        this.highscore = new Highscore();
        this.level = new Level();
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
}
