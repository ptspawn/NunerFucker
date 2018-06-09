package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.FileManagement;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.graphics.Text;

/**
 * Created by codecadet on 04/06/2018.
 */
public class HighScores {
    private Rectangle backGround;
    private FileManagement fileManagement;

    public HighScores(FileManagement fileManagement) {

        backGround = new Rectangle(20,20,500,500);
        backGround.draw();

        for (int i = 0; i < fileManagement.getHighScores().length; i++) {
            if (fileManagement.getHighScores()[i] != null) {
                Text text = new Text(30, 20 + i * 30, fileManagement.getHighScores()[i]);
                text.draw();
            }
        }

    }
}
