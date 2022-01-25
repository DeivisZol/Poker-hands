public class Player {
    private Card[] hand = new Card[5];
    public Player(String hand) {
        for(int i = 0; i < 5; i++) {
            this.hand[i] = new Card(hand.substring((i*3), (i*3)+2));
        }
    }
    public Card[] getHand() {
        return this.hand;
    }
}
