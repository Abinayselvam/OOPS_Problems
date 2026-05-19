class CardQueue {

    Node front, rear;

    public void enqueue(Card card) {
        Node newNode = new Node(card);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Card dequeue() {
        if (front == null) return null;

        Card temp = front.data;
        front = front.next;

        if (front == null) rear = null;

        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.println("  " + temp.data);
            temp = temp.next;
        }
    }
}