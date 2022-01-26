package Aplication.Player;

import Aplication.Player.Card.Card;
import Aplication.Player.Card.CardValue;

import java.util.List;

public class Player {
    //player has hand with 5 card class objects.
    private final Card[] hand = new Card[5];
    private int highCard = 0;

    public Player(String hand) {
        for (int i = 0; i < 5; i++) {
            this.hand[i] = new Card(hand.substring((i * 3), (i * 3) + 2));
        }
        sortCards();
    }

    private void sortCards() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4 - i; j++)
                if (hand[j].getCardValue().ordinal() > hand[j + 1].getCardValue().ordinal()) {
                    Card temp = hand[j];
                    hand[j] = hand[j + 1];
                    hand[j + 1] = temp;
                }
    }

    public boolean royalFlush() {
        List<CardValue> allowedValues = List.of(CardValue.TEN, CardValue.JACK, CardValue.QUEEN, CardValue.KING, CardValue.ACE);
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardType() != hand[0].getCardType() || !allowedValues.contains(hand[i].getCardValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean straightFlush() {
        for (int i = 0; i < 4; i++) {
            if (hand[i + 1].getCardType() != hand[0].getCardType() || hand[i].getCardValue().ordinal() + 1 != hand[i + 1].getCardValue().ordinal()) {
                return false;
            }
        }
        return true;
    }

    public int fourOfAKind() {
        int type1 = 0;
        int type2 = 0;
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardValue() == hand[0].getCardValue()) {
                type1++;
            } else if (hand[i].getCardValue() == hand[4].getCardValue()) {
                type2++;
            } else {
                return 0;
            }
        }
        if (type1 == 4) {
            return hand[0].getCardValue().ordinal();
        } else if (type2 == 4) {
            this.highCard = hand[0].getCardValue().ordinal();
            return hand[4].getCardValue().ordinal();
        }
        return 0;
    }

    public int fullHouse() {
        int type1 = 0;
        int type2 = 0;
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardValue() == hand[0].getCardValue()) {
                type1++;
            } else if (hand[i].getCardValue() == hand[4].getCardValue()) {
                type2++;
            }
        }
        if (type1 == 3 && type2 == 2) {
            return hand[0].getCardValue().ordinal();
        } else if (type1 == 2 && type2 == 3) {
            return hand[4].getCardValue().ordinal();
        }
        return 0;
    }

    public boolean flush() {
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardType() != hand[0].getCardType()) {
                return false;
            }
        }
        return true;
    }

    public boolean straight() {
        for (int i = 0; i < 4; i++) {
            if (hand[i].getCardValue().ordinal() + 1 != hand[i + 1].getCardValue().ordinal()) {
                return false;
            }
        }
        return true;
    }

    public int threeOfAKind() {
        int type = 0;
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardValue() == hand[2].getCardValue()) {
                type++;
            }
        }
        if (type == 3) {
            return hand[2].getCardValue().ordinal();
        } else return 0;
    }

    public int twoPairs() {
        int type1 = 0;
        int type2 = 0;
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardValue() == hand[1].getCardValue()) {
                type1++;
            } else if (hand[i].getCardValue() == hand[3].getCardValue()) {
                type2++;
            }
        }
        if (type1 == 2 && type2 == 2) {
            if (hand[1].getCardValue().ordinal() > hand[3].getCardValue().ordinal()) {
                return hand[1].getCardValue().ordinal();
            } else {
                return highCard = hand[3].getCardValue().ordinal();
            }
        }
        return 0;
    }

    public int onePair() {
        int type1 = 0;
        int type2 = 0;
        int type3 = 0;
        for (int i = 0; i < 5; i++) {
            if (hand[i].getCardValue() == hand[0].getCardValue()) {
                type1++;
            } else if (hand[i].getCardValue() == hand[2].getCardValue()) {
                type2++;
            } else if (hand[i].getCardValue() == hand[4].getCardValue()) {
                type3++;
            }
        }
        if (type1 == 2) {
            return hand[0].getCardValue().ordinal();
        } else if (type2 == 2) {
            return hand[2].getCardValue().ordinal();
        } else if (type3 == 2) {
            this.highCard = hand[2].getCardValue().ordinal();
            return hand[4].getCardValue().ordinal();
        } else {
            return 0;
        }
    }

    public int highCard() {
        if (highCard == 0)
            return hand[4].getCardValue().ordinal();
        else {
            return this.highCard;
        }
    }


}
