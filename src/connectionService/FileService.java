package connectionService;


import java.io.*;
import java.util.Scanner;

public class FileService {
    File file;
    User[] usersInFile;
    String path;

    public FileService() {
        path = "gameData.xml";
    }

    public void readFile () throws IOException, ClassNotFoundException {
        file = new File(path);
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
        usersInFile = (User[]) input.readObject();
    }

    public User searchFile (String username, String password) {
        for (User user: usersInFile) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
