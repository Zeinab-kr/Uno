package connectionService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server /*implements Runnable*/ {
    public static void main(String[] args) throws IOException {
        User user;
        ServerSocket server = new ServerSocket(5757);
        Socket socket = server.accept();

        Scanner input = new Scanner(socket.getInputStream());
        Formatter output = new Formatter(socket.getOutputStream());

        String command = input.next();
        switch (command) {
            case "userCheck":
                user = new User(input.next(), input.next(), new int[]{0});
                user.hasAccount(user.getUsername(), user.getPassword());
            case "logIn":
            case "signUp":
            case "getScores":
            case "sendScore":
            case "changeUsername":
            case "changePassword":
        }
    }

    /*@Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(5757);
            Socket socket = server.accept();

            Scanner input = new Scanner(socket.getInputStream());
            Formatter output = new Formatter(socket.getOutputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }*/
}
