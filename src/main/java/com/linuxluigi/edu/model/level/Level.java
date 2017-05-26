package com.linuxluigi.edu.model.level;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linuxluigi.edu.model.board.Board;

import java.io.*;

/**
 * Created by fubu on 17.05.17.
 */
public class Level {
    public static void saveLevel(File file, Board board) {
        Gson gson = new GsonBuilder().create();
        String content = gson.toJson(board);

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Board loadLevel(File file) {
        Board board = new Board();

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String row;
            String content = "";

            while ((row = br.readLine()) != null) {
                content = content + row;
            }
            br.close();

            Gson gson = new GsonBuilder().create();
            board = gson.fromJson(content, Board.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return board;
    }
}
