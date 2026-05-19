class Player {

    int id;
    CardQueue cards = new CardQueue();

    public Player(int id) {
        this.id = id;
    }

    // Sort cards by rank (simple bubble sort using array temp)
    public void sortCards() {

        Card[] temp = new Card[9];
        int i = 0;

        while (!cards.isEmpty()) {
            temp[i++] = cards.dequeue();
        }

        // rank order
        String[] ranks = {"2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};

        // bubble sort
        for (int a = 0; a < temp.length - 1; a++) {
            for (int b = 0; b < temp.length - a - 1; b++) {

                if (getRankValue(temp[b], ranks) > getRankValue(temp[b+1], ranks)) {
                    Card t = temp[b];
                    temp[b] = temp[b+1];
                    temp[b+1] = t;
                }
            }
        }

        // put back into queue
        for (Card c : temp) {
            cards.enqueue(c);
        }
    }

    private int getRankValue(Card c, String[] ranks) {
        for (int i = 0; i < ranks.length; i++) {
            if (c.rank.equals(ranks[i])) return i;
        }
        return -1;
    }

    public void showCards() {
        System.out.println("Player " + id + " cards:");
        cards.display();
    }
}