package org.academiadecodigo.bootcamp.GameEngine;

import java.io.*;
import java.util.Arrays;

/**
 * Created by codecadet on 09/06/2018.
 */
public class FileManagement {
    public static final String PATH_FILE = "Resources/HighScore/highscores.nun";
    private String[] highScores = new String[5];
    private String[] newHighScore = new String[highScores.length + 1];

    public FileManagement() {
        readScores();
    }

    private void readScores() {
        try {
            BufferedReader bRead = new BufferedReader(new FileReader(PATH_FILE));
            String line = bRead.readLine();
            int count = 0;

            while (line != null) {
                highScores[count] = line;
                newHighScore[count] = line;
                count++;
                line = bRead.readLine();
            }
            bRead.close();
            Arrays.sort(highScores, 0, highScores.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHighScores() {
        for (String hS : highScores) {
            System.out.println(hS);
        }

    }

    private void writeScores() {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(PATH_FILE));
            int index = newHighScore.length - 1;

            for (int i = 0; i < highScores.length; i++) {
                bWriter.write(newHighScore[index] + "\n");
                index--;
            }

            bWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getHighScores() {
        return highScores;
    }

    public void setHighScore(String score) {
        newHighScore[5] = score;
        Arrays.sort(newHighScore, 0, newHighScore.length);
        writeScores();
    }

}


