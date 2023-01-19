package client.game;

import client.Player;
import client.cards.Card;
import client.domain.Pile;

import java.util.ArrayList;

/**
 * This class builds the context of the game
 * such as cards, card storage, decks, ...
 */
public class GameContext {
    private int playerCount;
    private Pile cardPile;
    private Player[] players;

    /**
     * builds the pile of cards
     */
    private void buildPile() {
        cardPile = new Pile();
        System.out.println(cardPile.makeCards());
    }

    /**
     * single player game
     * @param num number of players preferred by the player
     * @param username player's username
     */
    private void buildPlayers(int num, String username) {
        players[0] = new Player(username);
        for (int i = 1; i < num; i++) {
            players[i] = new Player("Player" + i);
        }
    }

    /**
     * creates player's hands at the
     * beginning of the game
     * @param num number of players
     */
    private void drawCards(int num) {
        int part = cardPile.getSize();
        int cardCount = cardPile.getSize();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 7; j++) {
                players[i].createHand(cardPile.drawOneAndRemove());
            }
        }
    }

    /**
     *
     * @param numOfPlayers number of players
     * @param playerUsername player's username
     */
    public void buildGame(int numOfPlayers, String playerUsername) {
        buildPlayers(numOfPlayers, playerUsername);
        buildPile();
        drawCards(numOfPlayers);
    }

    public int getPlayerCount() {
        return playerCount;
    }
}
