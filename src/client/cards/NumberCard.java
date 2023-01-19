package client.cards;

/**
 * This class represents the number cards
 */
public class NumberCard extends Card{
    private int number;

    public NumberCard(int point, String color, int number) {
        super(point, color);
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
