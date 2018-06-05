package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Line;
import org.academiadecodigo.notsosimplegraphics.graphics.Text;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/06/2018.
 */
public class RotationTest {

    public static void main(String[] args) throws InterruptedException {


        Canvas canvas = Canvas.getInstance();
        double[] canvasDim = canvas.getScreenDimentions();

        Line[] hLines = new Line[(int) (canvasDim[1] / 100)];
        System.out.println("Horizontal Lines: " + canvasDim[0] / 100 + "\nHorizontal Lines: " + hLines.length);

        Line[] vLines = new Line[(int) (canvasDim[0] / 100)];
        System.out.println("Vertical Lines: " + canvasDim[1] / 100 + "\nVertical Lines: " + vLines.length);

        for (int i = 0; i / 100 < hLines.length; i += 100) {
            System.out.println("i: " + i + " canvas Width:" + canvasDim[0]);
            hLines[i / 100] = new Line(0, i, canvasDim[0], i);
            hLines[i / 100].draw();

        }

        for (int i = 0; i / 100 < vLines.length; i += 100) {
            System.out.println("i: " + i + " Canvas Height:" + canvasDim[1]);
            vLines[i / 100] = new Line(i, 0, i, canvasDim[1]);
            vLines[i / 100].draw();

        }

        Text mousePosText = new Text(0, 0, "Container for mousePos");
        mousePosText.draw();

        Picture arrow = new Picture(canvasDim[0] / 2, canvasDim[1] / 2, "Characters/player.png");
        arrow.translate(-arrow.getWidth() / 2, -arrow.getHeight() / 2);
        arrow.draw();


        Text angleText = new Text(0, 30, "Angle");
        angleText.draw();

        double angle;
        InputManager inputManager = new InputManager();

        while (true) {

            double[] mousePos = inputManager.getMousePos();
            mousePosText.setText("x: " + mousePos[0] + " - y: " + mousePos[1]);
            System.out.println("Mouse: X-" + mousePos[0] + " Y-" + mousePos[1]);

            angle = rotate(mousePos, arrow, Math.PI/2);

            angleText.setText(Double.toString(Math.toDegrees(angle)));

            arrow.rotate(angle);
            Thread.sleep(200);
        }

    }

    private static double rotate(double[] mousePos, Picture picToRotate, double buffer) {

        double[] picCenter = new double[2];

        picCenter[0] = picToRotate.getX() + picToRotate.getWidth() / 2;
        picCenter[1] = picToRotate.getY() + picToRotate.getHeight() / 2;

        double[] vector = new double[2];

        vector[0] = mousePos[0] - picCenter[0];
        vector[1] = mousePos[1] - picCenter[1];

        double angle = Math.atan(vector[1] / vector[0]);

        if (vector[0] < 0) {
            angle = angle + buffer + 2 * Math.PI;
        }
        if (angle + buffer > 2 * Math.PI) {
            angle = angle + buffer - 2 * Math.PI;
        }

        return angle + buffer;
    }
}
