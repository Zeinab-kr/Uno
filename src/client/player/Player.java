package client.player;

import client.cards.Card;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Makes a new player
 */

public class Player {
    private String username;
    private String password;
    private int[] scores;
    private ArrayList<Card> hand = new ArrayList<>();
    Socket socket = new Socket("localhost", 5757);

    /**
     * no matter if the player has an account or not,
     * makes a Player object with the given
     * username and password
     * @param username username entered by player
     */
    public Player(String username, String password) throws IOException {
        this.username = username;
        this.password = password;
        this.scores = new int[]{0};
    }

    public Player(String username) throws IOException {
        this.username = username;
        this.password = null;
        this.scores = new int[]{0};
    }

    /**
     * sends the data to the server to check if
     * the player has an account and assigns
     * the data sent by server to the Player
     * object parameters
     * @throws IOException if client could not connect to server
     */
    public void isAUser() throws IOException {
        try {
            Scanner receivedFromServer = new Scanner(socket.getInputStream());
            Formatter sendToServer = new Formatter(socket.getOutputStream());

            // send the username and password to server
            sendToServer.format("findUser");
            sendToServer.flush();
            sendToServer.format(username);
            sendToServer.flush();
            sendToServer.format(password);
            sendToServer.flush();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public void createHand(Card card) {
        hand.add(card);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws IOException {
        this.username = username;
        try {
            Scanner receivedFromServer = new Scanner(socket.getInputStream());
            Formatter sendToServer = new Formatter(socket.getOutputStream());
            sendToServer.format("changeUsername");
            sendToServer.flush();
            sendToServer.format(username);
            sendToServer.flush();
            sendToServer.format(password);
            sendToServer.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
