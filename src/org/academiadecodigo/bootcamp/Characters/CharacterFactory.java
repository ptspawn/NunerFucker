package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.CharactersType;

/**
 * Created by codecadet on 02/06/2018.
 */
public class CharacterFactory {

    public static Character getNewCharacter(CharactersType charactersType, double[] startingPosition) {

        int random = (int) (Math.random() * CharactersType.values().length);

        Character character;

        switch (charactersType) {
            case PLAYER:
                character = new Player("Sardinha",50,50);
                break;
            case ENEMY:
                character = new Enemy(startingPosition, CharactersType.ENEMY);
                break;
            default:
                character = new Enemy(startingPosition,CharactersType.ENEMY);
                break;
        }
        return character;
    }
}
