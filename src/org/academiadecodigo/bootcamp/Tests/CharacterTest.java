package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Characters.Character;
import org.academiadecodigo.bootcamp.Characters.CharacterFactory;
import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;

/**
 * Created by codecadet on 02/06/2018.
 */
public class CharacterTest {

    public static void main(String[] args) {

         Character[] characters = new Character[5];

        for (int i = 0; i < characters.length; i++) {
            characters[i] = CharacterFactory.getNewCharacter();
            System.out.println(characters[i]);
        }

        Character character1 = new Enemy();
        Character character2 = new Player("Godolfo", 50,50);

        System.out.println(character1);
        System.out.println(character2);






    }

}
