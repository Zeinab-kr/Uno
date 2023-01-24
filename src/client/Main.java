package client;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandParser commandParser = new CommandParser();
        ConsoleViewer consoleViewer = new ConsoleViewer();
        Scanner scanner = new Scanner(System.in);

        consoleViewer.welcome();
        consoleViewer.startMenu();
        commandParser.startAction(scanner.nextInt());
    }
}
