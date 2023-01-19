package Client;

/**
 * This class builds the context of the game
 * such as cards, card storage, decks, ...
 */
public class GameContext {
    public static void buildStorage() {
        Storage cardStorage = new Storage();
        System.out.println(cardStorage.makeCards());
    }

}
