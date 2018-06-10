package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.FileManagement;

import java.io.IOException;

/**
 * Created by codecadet on 09/06/2018.
 */
public class FileManagementTest {
    public static void main(String[] args) throws IOException {
        final String PATH_FILE = "Resources/HighScore/highscores.nun";
        FileManagement fileManagement = new FileManagement();

        fileManagement.setHighScore("198 Nuns - Rita");
        System.out.println("updated");
        fileManagement.showHighScores();





  /*      String[] hs = {"Rita - 140 Nun", "Tiago - 90 Nun", "Miguel - 180 Nun", "Sardinha - 140 Nun"};

        Arrays.sort(hs);

       // for (String fruit : hs) {
         //   System.out.println(fruit);
        //}
        fileManagement.showHighScores();
*/
    }
}
