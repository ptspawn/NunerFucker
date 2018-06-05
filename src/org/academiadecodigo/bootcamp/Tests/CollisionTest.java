package org.academiadecodigo.bootcamp.Tests;


import org.academiadecodigo.bootcamp.GameEngine.CheckCollision;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import javax.xml.stream.events.Characters;

import static org.academiadecodigo.bootcamp.GameEngine.CheckCollision.checkCollision;


/**
 * Created by codecadet on 05/06/2018.
 */
public class CollisionTest {

    public static void main(String[] args) {


        Picture picture = new Picture(10, 10, "Characters/player.png");
        Picture picture1 = new Picture(10, 10, "Characters/player.png");
        Picture picture2= new Picture(50, 50, "Characters/player.png");
        Picture picture3 = new Picture(100, 100, "Characters/player.png");
        Picture picture4 = new Picture(10, 10, "Characters/player.png");
        Picture picture5 = new Picture(10, 10, "Characters/player.png");

        System.out.println(checkCollision(picture, picture1, 20));
        System.out.println(checkCollision(picture, picture2, 20));
        System.out.println(checkCollision(picture, picture3, 20));
        System.out.println(checkCollision(picture, picture4, 20));
        System.out.println(checkCollision(picture, picture5, 20));
        System.out.println(checkCollision(picture2, picture1, 20));
        System.out.println(checkCollision(picture3, picture4, 20));
        System.out.println(checkCollision(picture3, picture5, 20));
        System.out.println(checkCollision(picture4, picture5, 20));






    }

}
