package Aplication.Player.Card;

import java.util.Arrays;

public enum CardType {
    DIAMONDS('D'),
    CLUBS('C'),
    HEARTS('H'),
    SPADES('S');

    private final char value;

    CardType(char value) {
        this.value = value;
    }


    /**
     * From char input finds first match of enum and sets value accordingly
     * @param value 'D'
     * @return DIAMONDS
     */
    public static CardType valueOf(char value) {
        return Arrays.stream(values())
                .filter(cardType -> cardType.value == value)
                .findFirst()
                .orElse(null);
    }
}
