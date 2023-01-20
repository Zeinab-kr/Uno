package connectionService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server implements Runnable {
    /*public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5757);
        Socket socket = server.accept();

        Scanner input = new Scanner(socket.getInputStream());
        Formatter output = new Formatter(socket.getOutputStream());
    }*/

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(5757);
            Socket socket = server.accept();

            Scanner input = new Scanner(socket.getInputStream());
            Formatter output = new Formatter(socket.getOutputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
