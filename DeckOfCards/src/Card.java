class Card {
    String suit;
    String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}