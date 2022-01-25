public class Card {
    private CardType cardType;
    private CardClass cardClass;

    Card(String card) {
        switch (card.charAt(0)) {
            case 2 -> cardClass = CardClass.TWO;
            case 3 -> cardClass = CardClass.THREE;
            case 4 -> cardClass = CardClass.FOUR;
            case 5 -> cardClass = CardClass.FIVE;
            case 6 -> cardClass = CardClass.SIX;
            case 7 -> cardClass = CardClass.SEVEN;
            case 8 -> cardClass = CardClass.EIGHT;
            case 9 -> cardClass = CardClass.NINE;
            case 'T' -> cardClass = CardClass.TEN;
            case 'J' -> cardClass = CardClass.JACK;
            case 'Q' -> cardClass = CardClass.QUEEN;
            case 'K' -> cardClass = CardClass.KING;
            case 'A' -> cardClass = CardClass.ACE;
        }
        switch (card.charAt(1)) {
            case 'D' -> cardType = CardType.DIAMONDS;
            case 'C' -> cardType = CardType.CLUBS;
            case 'H'-> cardType = CardType.HEARTHS;
            case 'S' -> cardType = CardType.SPADES;
        }
    }

    public CardClass getCardClass() {
        return cardClass;
    }

    public CardType getCardType() {
        return cardType;
    }
}
