package client;

import client.domain.Pile;

/**
 * This class builds the context of the game
 * such as cards, card storage, decks, ...
 */
public class GameContext {
    public static void buildPile() {
        Pile cardPile = new Pile();
        System.out.println(cardPile.makeCards());
    }

}
