import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private Player player1;
    private Player player2;
    private int player1Wins;

    public void initializeGames() {
        try {
            File file = new File("poker.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                this.player1 = new Player(st.substring(0, 14));
                this.player2 = new Player(st.substring(15, 29));
                boolean player1Winner = playGame();
                if (player1Winner) {
                    System.out.println("Winner Player 1");
                    this.player1Wins++;
                } else {
                    System.out.println("Winner Player 2");
                }
            }
            System.out.println("Player 1 won :" + player1Wins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean playGame() {
        if (player1.royalFlush() || player2.royalFlush()) {
            if (player1.royalFlush() && !player2.royalFlush()) {
                return true;
            } else if (player1.royalFlush() && player2.royalFlush()) {
                return player1.highCard() > player2.highCard();
            }
            return false;
        } else if (player1.straightFlush() || player2.straightFlush()) {
            if (player1.straightFlush() && !player2.straightFlush()) {
                return true;
            } else if (player1.straightFlush() && player2.straightFlush()) {
                return player1.highCard() > player2.highCard();
            }
            return false;
        } else if (player1.fourOfAKind() > 0 || player2.fourOfAKind() > 0) {
            if (player1.fourOfAKind() > 0 && player2.fourOfAKind() == 0) {
                return true;
            } else if (player1.fourOfAKind() > 0 && player2.fourOfAKind() > 0) {
                if (player1.fourOfAKind() == player2.fourOfAKind()) {
                    return player1.highCard() > player2.highCard();
                } else
                    return player1.fourOfAKind() > player2.fourOfAKind();
            }
            return false;
        } else if (player1.fullHouse() > 0 || player2.fullHouse() > 0) {
            if (player1.fullHouse() > 0 && player2.fullHouse() == 0) {
                return true;
            } else if (player1.fullHouse() > 0 && player2.fullHouse() > 0) {
                return player1.fullHouse() > player2.fullHouse();
            }
            return false;
        } else if (player1.flush() || player2.flush()) {
            if (player1.flush() && !player2.flush()) {
                return true;
            } else if (player1.flush() && player2.flush()) {
                return player1.highCard() > player2.highCard();
            }
            return false;
        } else if (player1.straight() || player2.straight()) {
            if (player1.straight() && !player2.straight()) {
                return true;
            } else if (player1.straight() && player2.straight()) {
                return player1.highCard() > player2.highCard();
            }
            return false;
        }  else if (player1.threeOfAKind() > 0 || player2.threeOfAKind() > 0) {
            if (player1.threeOfAKind() > 0 && player2.threeOfAKind() == 0) {
                return true;
            } else if (player1.threeOfAKind() > 0 && player2.threeOfAKind() > 0) {
                if (player1.threeOfAKind() == player2.threeOfAKind()) {
                    return player1.highCard() > player2.highCard();
                } else
                    return player1.threeOfAKind() > player2.threeOfAKind();
            }
            return false;
        } else if (player1.twoPairs() > 0 || player2.twoPairs() > 0) {
            if (player1.twoPairs() > 0 && player2.twoPairs() == 0) {
                return true;
            } else if (player1.twoPairs() > 0 && player2.twoPairs() > 0) {
                if (player1.twoPairs() == player2.twoPairs()) {
                    return player1.highCard() > player2.highCard();
                } else
                    return player1.twoPairs() > player2.twoPairs();
            }
            return false;
        } else if (player1.onePair() > 0 || player2.onePair() > 0) {
            if (player1.onePair() > 0 && player2.onePair() == 0) {
                return true;
            } else if (player1.onePair() > 0 && player2.onePair() > 0) {
                if (player1.onePair() == player2.onePair()) {
                    return player1.highCard() > player2.highCard();
                } else
                    return player1.onePair() > player2.onePair();
            }
            return false;
        }
        return player1.highCard() > player2.highCard();
    }
}
