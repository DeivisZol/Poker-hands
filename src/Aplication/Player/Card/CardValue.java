package Aplication.Player.Card;

import java.util.Arrays;

public enum CardValue {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final char value;

    CardValue(char value) {
        this.value = value;
    }

    /**
     * From char input finds first match of enum and sets value accordingly
     * @param value value 2,3,4,5,...,queen,king,ace - in char format
     * @return Enum type value accordingly to input
     */
    public static CardValue valueOf(char value) {
        return Arrays.stream(values())
                .filter(cardValue -> cardValue.value == value)
                .findFirst()
                .orElse(null);
    }
}
