package Client;

import java.util.Random;

public class Store {
    private Card[] cards;
    private int cardNum = -1;

    /**
     * creates cards and makes the card storage
     *
     * @return a String that tells if the cards are ready
     */
    public String makeCards() {
        String[] cardColor = {"Red", "Yellow", "Green", "Blue"};
        String[] actions = {"Skip", "Reverse", "Draw2"};
        String[] wildActions = {"WildColor", "WildDraw4"};


        // create number cards
        for (String color: cardColor){
            for (int j = 0; j < 10; j++) {
                cards[++cardNum] = new NumberCard(j, color, j);
            }
            for (int j = 1; j < 10; j++) {
                cards[++cardNum] = new NumberCard(j, color, j);
            }
        }

        // create action cards
        for (String color: cardColor) {
            for (String action: actions) {
                cards[++cardNum] = new ActionCard(20, color, action);
            }
        }
        for (String color: cardColor) {
            for (String action: actions) {
                cards[++cardNum] = new ActionCard(20, color, action);
            }
        }

        // create wild cards
        for (String wildAction: wildActions) {
            for (int i = 0; i < 4; i++) {
                cards[++cardNum] = new WildCard(50, wildAction);
            }
        }

        shuffleCards();

        return "Cards are ready!";
    }

    /**
     * shuffles the cards in the storage
     */
    public void shuffleCards() {
        int index;
        Card temp;
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }

    }

    public Card[] getCards() {
        return cards;
    }
}
