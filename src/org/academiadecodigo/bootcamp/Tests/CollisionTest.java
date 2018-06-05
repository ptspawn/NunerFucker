package org.academiadecodigo.bootcamp.Tests;


import com.sun.org.apache.regexp.internal.RE;
import org.academiadecodigo.bootcamp.GameEngine.CheckCollision;
import org.academiadecodigo.bootcamp.Interfaces.Collidable;

import java.awt.*;

/**
 * Created by codecadet on 05/06/2018.
 */
public class CollisionTest {

    public static void main(String[] args) {





        Rectangle rect1 = new Rectangle(45, 45, 50, 50);
        Rectangle rect2 = new Rectangle(100, 100, 100, 100);
        Rectangle rect3= new Rectangle(150, 150, 50, 50);


        Rectangle rect4 = new Rectangle(105, 105, 50, 50);
        Rectangle rect5 = new Rectangle(120, 120, 100, 100);
        Rectangle rect6= new Rectangle(50, 50, 50, 50);

        Rectangle[] rectangles1 = {rect1, rect2, rect3};
        Rectangle[] rectangles2 = {rect4, rect5, rect6};

        CheckCollision collisionTest = new CheckCollision(rectangles1, rectangles2);


        collisionTest.check();




    }

}
