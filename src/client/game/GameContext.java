package client.game;

import client.player.Player;
import client.domain.Pile;

import java.io.IOException;
import java.util.HashMap;

/**
 * This class builds the context of the game
 * such as cards, card storage, decks, ...
 */
public class GameContext {
    private int playerCount;
    private Pile cardPile;
    private Player[] players;
    private HashMap<Player, Integer> scoresThisRound = new HashMap<Player, Integer>();

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
     */
    private void buildPlayers(int num, Player user) throws IOException {
        players[0] = user;
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
     * @param numOfPlayer number of players
     * @param user the user
     */
    public void buildGame(int numOfPlayer, Player user) throws IOException {
        buildPlayers(numOfPlayer, user);
        buildPile();
        drawCards(numOfPlayer);
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public HashMap<Player, Integer> getScoresThisRound() {
        return scoresThisRound;
    }

    public Player getPlayer() {
        return players[0];
    }

    public void setPlayerScores(int[] scores) {
        players[0].setScores(scores);
    }

    public void buildPlayer(String username, String password) throws IOException {
        players[0] = new Player(username, password);
    }
}
