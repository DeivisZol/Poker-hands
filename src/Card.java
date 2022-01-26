public class Card {
    private final CardType cardType;
    private final CardValue cardValue;

    public Card(String card) {
        cardValue = CardValue.valueOf(card.charAt(0));
        cardType = CardType.valueOf(card.charAt(1));
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public CardType getCardType() {
        return cardType;
    }
}
