package Aplication.Player.Card;

public class Card {
    //Card object has type(clubs, hearts, spades, diamonds) and value from 2,3,4,...,queen, king, ace.
    private final CardType cardType;
    private final CardValue cardValue;

    /**
     * Converts from single char to enum type
     * @param card 2H
     * CardValue.valueOf(2) -> cardValue = TWO
     * CardType.valueOf(H) -> cardType = HEARTS
     */
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
