package client.cards;

/**
 * This is an abstract class that represents all cards
 */

public abstract class Card {
    private int point;
    private String color;

    public Card(int point, String color) {
        this.point = point;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getPoint() {
        return point;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
