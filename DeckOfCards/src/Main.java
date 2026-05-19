import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};

        // Step 1: Create deck
        String[] deck = new String[52];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Step 2: Shuffle
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randomIndex = rand.nextInt(52);

            // swap
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        // Step 3: Distribute to 4 players (9 cards each)
        String[][] players = new String[4][9];

        int cardIndex = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }

        // Step 4: Print
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + ":");

            for (int j = 0; j < 9; j++) {
                System.out.println("  " + players[i][j]);
            }

            System.out.println();
        }
    }
}