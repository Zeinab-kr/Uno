package connectionService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server implements Runnable {
    User user;

    public static void main(String[] args) {
        Thread connection = new Thread(new Server());
        connection.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(5757);
            Socket socket = server.accept();

            Scanner inputString = new Scanner(socket.getInputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            Formatter outputString = new Formatter(socket.getOutputStream());

            String command = inputString.next();
            switch (command) {
                case "userCheck":
                    user = new User(inputString.next(), inputString.next(), new int[]{0});
                    if (user.hasAccount()) {
                        output.writeInt(1);
                    } else {
                        output.writeInt(0);
                    }
                    output.flush();
                case "logIn":
                    user = new User(inputString.next(), inputString.next(), new int[]{0});
                    int[] scores = user.logIn();
                    user.setScores(scores);
                    output.writeObject(user);
                    output.flush();

                case "getScores":
                case "sendScore":
                case "changeUsername":
                case "changePassword":
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
