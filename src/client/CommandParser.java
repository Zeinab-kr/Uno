package client;

import client.player.Player;

import java.io.IOException;
import java.util.Scanner;

public class CommandParser {
    ConsoleViewer menu = new ConsoleViewer();
    Scanner scanner = new Scanner(System.in);

    /*public void commandParser() throws IOException {
        int input;
        menu.welcome();

        menu.startMenu();
        if (!startAction(scanner.nextInt())) return;

        logInAction();
    }*/



    public boolean startAction(int input) throws IllegalArgumentException {
        if (input == 1) {

        } else return false;
    }

    public void logInAction() throws IOException {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        Player player = new Player(username, password);
    }

}
