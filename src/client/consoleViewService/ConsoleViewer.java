package client.consoleViewService;

import client.cards.ActionCard;
import client.cards.Card;
import client.cards.NumberCard;
import client.cards.WildCard;
import client.player.Player;

public class ConsoleViewer {
    public void welcome() {
        System.out.println("***           ***  ********  **          ******    *****    ****    ****  ********");
        System.out.println(" ***   ***   ***   **        **         **        **   **   ** **  ** **  **");
        System.out.println("  *** ** ** ***    *****     **        **        **     **  **  ****  **  *****");
        System.out.println("   ***     ***     **        **         **        **   **   **        **  **");
        System.out.println("    ***   ***      ********  ********    ******    *****    **        **  ********");
        System.out.println();
        System.out.println("           ********    *****              **    **   ****    **    *****");
        System.out.println("              **      **   **             **    **   ** **   **   **   **");
        System.out.println("              **     **     **            **    **   **  **  **  **     **");
        System.out.println("              **      **   **             **    **   **   ** **   **   **");
        System.out.println("              **       *****               ******    **    ****    *****");
        System.out.println();
    }

    public void startMenu() {
        System.out.println("1. Log in /n" +
                "2. Exit /n");
    }

    public void logInMenu(String name) {
        System.out.println("Logged in successfully! Welcome back " + name + "/n");
        System.out.println("1. New game /n" +
                "2. Score board /n" +
                "3. Exit game");
    }

    public void signUpMenu(String name) {
        System.out.println("Signed up successfully! Welcome to UNO " + name + "/n");
        System.out.println("1. New game /n" +
                "2. Exit game");
    }

    /**
     * gets the player and prints the
     * cards in their hand
     * @param player player
     */
    public void handMenu(Player player) {
        int i = 0;
        for (Card card: player.getHand()) {
            System.out.print(++i + ". ");
            System.out.println((card instanceof NumberCard) ?
                    ((NumberCard) card).getNumber() :
                    ((card instanceof ActionCard) ?
                            ((ActionCard) card).getAction() :
                            ((WildCard) card).getWildAction()));
        }
    }

    public void endOfGameMenu(Player winner) {
        System.out.println(winner.getUsername() + " won the game! /n");
        System.out.println("1. Show scores /n" +
                "2. New game /n" +
                "3. Exit game");
    }

    public void playersScores(Player[] players) {
        for (Player person: players) {
            System.out.println(person.getUsername() + ": " + person.getScores()[]);
        }
    }
}
