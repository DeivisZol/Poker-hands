package Tests;

import Aplication.Game.Game;
import Aplication.Player.Card.Card;
import Aplication.Player.Card.CardType;
import Aplication.Player.Card.CardValue;
import Aplication.Player.Player;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    //where booleans                 true = player 1 wins                 false = player 1 losses
    //first time creating unit tests, should cover more code not just winning functions, also edge cases not just basic.
    @Test
    public void givenFullHouse() {
        Game game = new Game(new Player("TS TH TC KS KH"), new Player("2C 3S 8S 8D TD"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = true;
        Assert.assertEquals(actualWinner, expectedWinner);
    }

    @Test
    public void givenCard() {
        Card card = new Card("TS");

        CardValue actualCardValue = card.getCardValue();
        CardValue expectedCardValue = CardValue.TEN;
        Assert.assertEquals(actualCardValue, expectedCardValue);

        CardType actualCardType = card.getCardType();
        CardType expectedCardType = CardType.SPADES;
        Assert.assertEquals(actualCardType, expectedCardType);
    }

    @Test
    public void givenStraightFlush() {
        Game game = new Game(new Player("7S 8S 9S TS JS"), new Player("8S 9S TS JS QS"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = false;
        Assert.assertEquals(actualWinner, expectedWinner);
    }

    @Test
    public void givenFourOfAKind() {
        Game game = new Game(new Player("7S 7D 7H 7C JS"), new Player("8S 5S TS JS QS"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = true;
        Assert.assertEquals(actualWinner, expectedWinner);
    }

    @Test
    public void givenFlush() {
        Game game = new Game(new Player("7S 7S 7S 4S JS"), new Player("8S 5S TS JH QS"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = true;
        Assert.assertEquals(actualWinner, expectedWinner);
    }

    @Test
    public void givenStraight() {
        Game game = new Game(new Player("7H 8S 9S TH JS"), new Player("8S 5S TH JS QS"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = true;
        Assert.assertEquals(actualWinner, expectedWinner);
    }

    @Test
    public void givenPair() {
        Game game = new Game(new Player("2C 3S 8S 8D TD"), new Player("5H 5C 6S 7S KD"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = true;
        Assert.assertEquals(actualWinner, expectedWinner);
    }

    @Test
    public void givenHighestCard() {
        Game game = new Game(new Player("5D 8C 9S JS AC"), new Player("2C 5C 7D 8S QH"));
        boolean actualWinner = game.playGame();
        boolean expectedWinner = true;
        Assert.assertEquals(actualWinner, expectedWinner);
    }


}
