package connectionService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private int[] scores;
    FileService fileService = new FileService();

    public User(String username, String password, int[] scores) {
        this.username = username;
        this.password = password;
        this.scores = scores;
    }

    public int[] logIn() {
        User user = fileService.searchFile(username, password);
        if (user != null) {
            return user.getScores();
        }
        else {
            return new int[]{0};
        }
    }

    public boolean hasAccount() {
        if (fileService.searchFile(username, password) != null) {
            return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
}
