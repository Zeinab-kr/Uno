package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Connection {

    Socket socket;
    Scanner fromServer;
    Formatter toServer;
    {
        try {
            socket = new Socket("localhost", 5757);
            toServer = new Formatter(socket.getOutputStream());
            fromServer = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean userCheck(String username, String password) {
        toServer.format("userCheck");
        toServer.flush();
        toServer.format(username);
        toServer.flush();
        toServer.format(password);
        toServer.flush();

        int answer = fromServer.nextInt();
        return answer == 1;
    }

    public int[] logIn(String username, String password) {
        toServer.format("logIn");
        toServer.flush();
        toServer.format(username);
        toServer.flush();
        toServer.format(password);
        toServer.flush();

        return getScores(username, password);
    }

    public String signIn(String username, String password) {
        toServer.format("signIn");
        toServer.flush();
        toServer.format(username);
        toServer.flush();
        toServer.format(password);
        toServer.flush();

        return fromServer.next();
    }

    public int[] getScores(String username, String password) {
        toServer.format("getScores");
        toServer.flush();
        toServer.format(username);
        toServer.flush();
        toServer.format(password);
        toServer.flush();

        int size = fromServer.nextInt();
        int[] scores = new int[size];
        for (int i = 0; i < size; i++) {
            scores[i] = fromServer.nextInt();
        }

        return scores;
    }

    public void sendScore(String username, String password, Integer score) {
        toServer.format("sendScore");
        toServer.flush();
        toServer.format(username);
        toServer.flush();
        toServer.format(password);
        toServer.flush();
        toServer.format(score.toString());
        toServer.flush();
    }

    public String changeUsername(String currentName, String password, String newName) {
        toServer.format("changeUsername");
        toServer.flush();
        toServer.format(currentName);
        toServer.flush();
        toServer.format(password);
        toServer.flush();
        toServer.format(newName);
        toServer.flush();

        return fromServer.next();
    }

    public String changePassword(String username, String currentPass, String newPass) {
        toServer.format("changePassword");
        toServer.flush();
        toServer.format(username);
        toServer.flush();
        toServer.format(currentPass);
        toServer.flush();
        toServer.format(newPass);
        toServer.flush();

        return fromServer.next();
    }
}
