package client.game;

import client.player.Player;
import client.cards.Card;
import client.cards.WildCard;
import client.domain.Pile;

import java.util.ArrayList;

public class GameManger {

    /**
     * @param handCards player's cards in hand
     * @return random card in hand
     */
    public Card chooseCard(ArrayList<Card> handCards) {
        int handNum = handCards.size();
        int randomCardNum = (int) (Math.random() * handNum);
        Card chosenCard = handCards.get(randomCardNum);
        handCards.remove(randomCardNum);
        return chosenCard;
    }

    /**
     * gets the player and the card chosen by
     * them from their hand and adds it to
     * the pile
     * @param player player playing now
     * @param card card chosen by player
     */
    public void fromHandToPile(Player player, Card card, Pile pile) {
        pile.addToPile(card);
        player.removeFromHand(card);
    }

    /**
     * when player has to pick a card from pile
     * @param player player playing now
     */
    public void fromPileToHand(Player player, Pile pile) {
        player.addToHand(pile.drawOneAndRemove());
    }

    /**
     * check if the card chosen by the player
     * is valid to use
     * @param card the card chosen by player
     * @return true if valid, false if invalid
     */
    public boolean canBeUsed(Card card, ArrayList<Card> cards) {
        Card cardOnTop = cards.get(cards.size() - 1);
        if (card.equals(cardOnTop)) {
            return true;
        } else if (card instanceof WildCard) {
            boolean notSimilar = true;
            for (Card value : cards) {
                if (cardOnTop.equals(value)) {
                    notSimilar = false;
                    break;
                }
            }
            return notSimilar;
        }
        return false;
    }
}
