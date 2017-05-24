package com.linuxluigi.edu.model.board;

import com.linuxluigi.edu.model.StaticVar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fubu on 17.05.17.
 * Game field with every block, Ball & user line
 */
public class Board implements Cloneable {

    // Boardsize 14x14
    private final int boardRow = 14;
    private final int boardColum = 14;

    private List<Stone> stones = new ArrayList<Stone>();

    public Board() {
        generateDefaultBoard();
    }

    public void generateDefaultBoard() {

        double stoneWidth = StaticVar.defaultWidth / this.boardColum;
        double stoneHight = StaticVar.blockAreaHeight / this.boardRow;

        for (int i = 0; i < boardRow; i++) {
            for (int j = 0; j < boardColum; j++) {

                double positionX = stoneWidth * j;
                double positionY = stoneHight * i;

                Stone stone = new Stone("#666666", 100, true,
                true, positionX, positionY, stoneWidth, stoneHight, i, j);

                this.stones.add(stone);
            }
        }

    }
    public List<Stone> getStones() {
        return stones;
    }

    public void setStones(List<Stone> stones) {
        this.stones = stones;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
