package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.FileManagement;
import org.academiadecodigo.bootcamp.MenuScreens.HighScores;

import java.io.IOException;

/**
 * Created by codecadet on 09/06/2018.
 */
public class FileManagementTest {
    public static void main(String[] args) throws IOException {
        FileManagement fileManagement = new FileManagement();
        fileManagement.readScores(FileManagement.PATH_FILE);
  //      fileManagement.showHighScore();
//        fileManagement.writeScores(FileManagement.PATH_FILE, "Sardinha - 140 Nun");
 //       fileManagement.readScores(FileManagement.PATH_FILE);
  //      fileManagement.showHighScore();


        HighScores highScores = new HighScores(fileManagement);
    }
}
