import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};

        Card[] deck = new Card[52];
        int index = 0;

        // create deck
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(suit, rank);
            }
        }

        // shuffle
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int r = rand.nextInt(52);
            Card temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        // create players
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(i + 1);
        }

        // distribute 9 cards each
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i].cards.enqueue(deck[cardIndex++]);
            }
        }

        // sort and print
        for (Player p : players) {
            p.sortCards();
            p.showCards();
            System.out.println();
        }
    }
}