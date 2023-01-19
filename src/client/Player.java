package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Makes a new player
 */

public class Player {
    private String username;
    private String password;
    private int[] scores;

    /**
     * no matter if the player has an account or not,
     * makes a Player object with the given
     * username and password
     * @param username username entered by player
     * @param password password entered by player
     */
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
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
            Socket socket = new Socket("localhost", 5757);
            Scanner receivedFromServer = new Scanner(socket.getInputStream());
            Formatter sendToServer = new Formatter(socket.getOutputStream());
            // send the username and password to server
            sendToServer.format(username);
            sendToServer.flush();
            sendToServer.format(password);
            sendToServer.flush();

        } catch (IOException ioException)
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
