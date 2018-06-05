package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Characters.CharacterFactory;
import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.Projectiles.Bullet;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.getVector;
import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;

public class EnemyTest {
    public static void main(String[] args) {

    InputManager input = new InputManager();

    Enemy[] enemies = new Enemy[5];

    for (int i = 0; i <enemies.length ; i++) {
            enemies[i]=(Enemy)CharacterFactory.getNewCharacter();
        }




    double[] screenDim = Canvas.getInstance().getScreenDimentions();

    Bullet bullet = new Bullet(screenDim[0] / 2, screenDim[1] / 2);

    double[] bulletOrigin = {screenDim[0] / 2, screenDim[1] / 2};


        while(true){
        System.out.println(input.isFiring());
        if (input.isFiring()) {

            //bullet.move(normalizedVector(getVector(bulletOrigin, input.getMousePos())));
            break;
            }

        }

    }

}


