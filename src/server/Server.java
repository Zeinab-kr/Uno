package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Scanner;

/**
 * This class implements the server socket
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5757);
        Socket socket = server.accept();

        Scanner input = new Scanner(socket.getInputStream());
        Formatter output = new Formatter(socket.getOutputStream());
    }

    public void logIn(String username, String password) {

    }

    public boolean hasAccount(String username, String password) {

    }

    public void signUp(String username, String password) {

    }
}
