package client.domain;

import client.cards.ActionCard;
import client.cards.Card;
import client.cards.NumberCard;
import client.cards.WildCard;

import java.util.ArrayList;
import java.util.Collections;

public class Pile {
//    private Card[] cards;
    private ArrayList<Card> cards = new ArrayList<>();
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
                cards.add(new NumberCard(j, color, j));
//                cards[++cardNum] = new NumberCard(j, color, j);
            }
            for (int j = 1; j < 10; j++) {
                cards.add(new NumberCard(j, color, j));
//                cards[++cardNum] = new NumberCard(j, color, j);
            }
        }

        // create action cards
        for (String color: cardColor) {
            for (String action: actions) {
                cards.add(new ActionCard(20, color, action));
//                cards[++cardNum] = new ActionCard(20, color, action);
            }
        }
        for (String color: cardColor) {
            for (String action: actions) {
                cards.add(new ActionCard(20, color, action));
//                cards[++cardNum] = new ActionCard(20, color, action);
            }
        }

        // create wild cards
        for (String wildAction: wildActions) {
            for (int i = 0; i < 4; i++) {
                cards.add(new WildCard(50, wildAction));
//                cards[++cardNum] = new WildCard(50, wildAction);
            }
        }

        shuffleCards();

        return "Pile ready!";
    }

    /**
     * shuffles the cards in the storage
     */
    private void shuffleCards() {
        Collections.shuffle(cards);
    }

    public Card drawOneAndRemove() {
        Card temp = cards.get(cardNum);
        cards.remove(cardNum);
        cardNum--;
        return temp;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
}
