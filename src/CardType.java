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

    public static CardType valueOf(char value) {
        return Arrays.stream(values())
                .filter(cardType -> cardType.value == value)
                .findFirst()
                .orElse(null);
    }
}
