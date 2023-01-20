package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Connection implements Runnable{

    String[] commands = new String[]{"userCheck", "logIn", "getScores", "sendScore",
                                        "changeUsername", "changePassword"};

    @Override
    public void run() {
        try {
            Socket socket= new Socket("localhost", 5757);
            Scanner fromServer = new Scanner(socket.getInputStream());
            Formatter toServer = new Formatter(socket.getOutputStream());

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
