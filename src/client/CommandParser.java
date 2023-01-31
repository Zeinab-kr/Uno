package client;

import client.game.GameContext;
import client.game.GameManger;
import client.player.Player;

import java.io.IOException;
import java.util.Scanner;

public class CommandParser {
    ConsoleViewer consoleViewer = new ConsoleViewer();
    Scanner scanner = new Scanner(System.in);
    Connection connection = new Connection();
    GameContext context = new GameContext();
    GameManger manger = new GameManger();

    /**
     * depending on the user's choice,
     * logs into or exits the game
     * @param input user's input value
     * @throws IllegalArgumentException
     */
    public void startAction(int input) throws IOException, ClassNotFoundException {
        if (input == 1) {
            logInAction();
        } else if (input != 2) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    /**
     * gets the log-in information and checks if
     * the player is already a user, otherwise
     * signs them up
     * @throws IOException io exception
     */
    public void logInAction() throws IOException, ClassNotFoundException {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (connection.isUser(username, password)) {
            int[] scores = connection.logIn(username, password);
            context.buildPlayer(username, password);
            context.setPlayerScores(scores); // sets the user's scores saved in file
        } else {
            connection.signUp(username, password);
            context.buildPlayer(username, password);
            context.setPlayerScores(new int[]{0});
        }

        consoleViewer.logInMenu(username);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Number of players: ");
                int playerNum = scanner.nextInt();
                int[] scores = connection.logIn(username, password);
                Player user = new Player(username, password);
                user.setScores(scores);
                context.buildGame(playerNum, user);
            case 2:
                consoleViewer.printScoreBoard(username, password);
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
        }
    }
}
