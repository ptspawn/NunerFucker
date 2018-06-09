package org.academiadecodigo.bootcamp.GameEngine;

import java.io.*;

/**
 * Created by codecadet on 09/06/2018.
 */
public class FileManagement {
    public static final String PATH_FILE = "Resources/HighScore/highscores.nun";
    private String[] highScores = new String[10];

    public FileManagement() {
        try {
            readScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readScores() throws IOException {
        FileReader reader = new FileReader(PATH_FILE);
        BufferedReader bRead = new BufferedReader(reader);
        String line = bRead.readLine();
        int count = 0;

        while (line != null) {
            highScores[count] = line;
            count++;
            line = bRead.readLine();
        }
        bRead.close();
    }

    public void showHighScore() {

        for (String hS : highScores) {
            if (hS != null) {
                System.out.println(hS);
            }
        }
    }

    public void writeScores(String file, String newScore) throws IOException {
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < highScores.length; i++) {

            if (highScores[i] != null) {
                System.out.println(highScores[i]);
                bWriter.write(highScores[i] + "\n");
            }
        }
        bWriter.write(newScore);
        bWriter.close();
    }

    public String[] getHighScores() {
        return highScores;
    }
}


