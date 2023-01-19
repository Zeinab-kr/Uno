package client.cards;

public class ActionCard extends Card {
    private String action;
    public ActionCard(int point, String color, String action) {
        super(point, color);
        this.action = action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
