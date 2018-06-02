package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.CharactersType;

/**
 * Created by codecadet on 02/06/2018.
 */
public class CharacterFactory {

    public static Character getNewCharacter() {

        //random number for enemy creation;
        int random = (int) (Math.random() * CharactersType.values().length);

        CharactersType charactersType = CharactersType.values()[random];

        Character character;

        switch (charactersType) {
            case PLAYER:
                character = new Player("Sardinha");
                break;
            case ENEMY:
                character = new Enemy();
                break;
            default:
                character = new Enemy();
                break;
        }
        // return enemy
        return character;
    }
}
