package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Characters.Character;
import org.academiadecodigo.bootcamp.Characters.CharacterFactory;

/**
 * Created by codecadet on 02/06/2018.
 */
public class CharCreation {

    public static void main(String[] args) {

         Character[] character = new Character[5];

        for (int i = 0; i < character.length; i++) {
            character[i] = CharacterFactory.getNewCharacter();
        }

        System.out.println(character.toString());







    }

}
