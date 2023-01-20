package client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandParser commandParser = new CommandParser();
        ConsoleViewer consoleViewer = new ConsoleViewer();
        Scanner scanner = new Scanner(System.in);

        consoleViewer.welcome();
        consoleViewer.startMenu();
        commandParser.startAction(scanner.nextInt());
    }
}
