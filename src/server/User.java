package server;

public class User {
    private String username;
    private String password;
    private int[] scores;

    public User(String username, String password, int[] scores) {
        this.username = username;
        this.password = password;
        this.scores = scores;
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
