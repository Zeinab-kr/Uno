package connectionService;


import java.io.*;
import java.util.Scanner;

public class FileService {
    File file;
    User[] usersInFile;

    public void readFile (String path) throws IOException, ClassNotFoundException {
        file = new File(path);
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
        usersInFile = (User[]) input.readObject();
    }

    public boolean searchFile (String username, String password, int[] scores) {
        for (User user: usersInFile) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                scores = user.getScores();
                return true;
            }
        }
        return false;
    }
}
