package client;

import client.cards.ActionCard;
import client.cards.Card;
import client.cards.NumberCard;
import client.cards.WildCard;
import client.player.Player;

import java.util.ArrayList;

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
        System.out.println("1. Log in \n" +
                "2. Exit \n");
    }

    public void logInMenu(String name) {
        System.out.println("Logged in successfully! Welcome back " + name + "\n");
        System.out.println("1. New game \n" +
                "2. Score board \n" +
                "3. Exit game");
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
            System.out.println(person.getUsername() + ": ");
        }
    }

    public void printCardsInHand(ArrayList<Card> cards) {
        for (Card card: cards) {
            System.out.print(" ---------     ");
        }
        System.out.println();
        for (Card card: cards) {
            System.out.print("|         |    ");
        }
        System.out.println();
        for (Card card: cards) {
            if (card instanceof NumberCard) {
                System.out.print("|    " + ((NumberCard) card).getNumber() + "    |    ");
            } else if (card instanceof ActionCard) {
                int length = ((ActionCard) card).getAction().length();
                System.out.print("|");
                for (int i = 0; i < (9 - length) / 2; i++) {
                    System.out.print(" ");
                }
                System.out.print(((ActionCard) card).getAction());
                for (int i = 0; i < (9 - ((length % 2 == 0) ? (length / 2) : (length / 2 + 1))) / 2; i++) {
                    System.out.print(" ");
                }
                System.out.println("|    ");
            } else {
                int length = ((WildCard) card).getWildAction().length();
                System.out.print("|");
                for (int i = 0; i < (9 - length) / 2; i++) {
                    System.out.print(" ");
                }
                System.out.print(((WildCard) card).getWildAction());
                for (int i = 0; i < (9 - ((length % 2 == 0) ? (length / 2) : (length / 2 + 1))) / 2; i++) {
                    System.out.print(" ");
                }
                System.out.println("|    ");
            }
        }
        for (Card card: cards) {
            System.out.print("|         |    ");
        }
        System.out.println();
        for (Card card: cards) {
            System.out.print(" ---------     ");
        }
        System.out.println();
    }

    public void printScoreBoard(String username, String password) {
        Connection connect = new Connection();
        int[] scores = connect.getScores(username, password);
        System.out.println(username + "'s scores:");
        for (int score: scores) {
            System.out.println(score);
        }
    }
}
