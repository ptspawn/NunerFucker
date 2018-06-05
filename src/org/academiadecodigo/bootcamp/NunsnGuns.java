package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameEngine.Game;

/**
 * Created by codecadet on 02/06/2018.
 */
public class NunsnGuns {

    public static void main(String[] args) {
        try {
            Game game = new Game();

            game.start();

        } catch (InterruptedException e) {
            System.out.println("fudeu tudo!");
        }
    }
}
