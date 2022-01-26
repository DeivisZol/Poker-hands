package Aplication.Game;

import Aplication.Player.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private Player player1;
    private Player player2;
    private int player1Wins;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Game() {
    }

    public void gameResult() {
        System.out.println("Player 1 won :" + player1Wins);
    }

    public void playBoard(String st) {
        this.player1 = new Player(st.substring(0, 14));
        this.player2 = new Player(st.substring(15, 29));
        boolean player1Winner = playGame();
        printWinner(player1Winner);
    }

    public void printWinner(boolean player1Winner) {
        if (player1Winner) {
            System.out.println("Winner Player 1");
            this.player1Wins++;
        } else {
            System.out.println("Winner Player 2");
        }
    }

    public void initializeGames() {
        try {
            File file = new File("poker.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                playBoard(st);
            }
            gameResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean playGame() {
        boolean player1HigherCard = player1.highCard() > player2.highCard();

        //For more object-oriented way I would need to create an interface, and several classes that implement such interface
        //Create objects for each type of "Combo"(Royal flush, full house, ...) and put in array then use for loop to go through
        //for (Base implementation : arrayOfComboTypes[]) {
        //    implementation.test();
        //}
        switch (compareBooleans(player1.royalFlush(), player2.royalFlush(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.straightFlush(), player2.straightFlush(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.fourOfAKind(), player2.fourOfAKind(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.fullHouse(), player2.fullHouse(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.flush(), player2.flush(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.straight(), player2.straight(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.threeOfAKind(), player2.threeOfAKind(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.twoPairs(), player2.twoPairs(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        switch (compareBooleans(player1.onePair(), player2.onePair(), player1HigherCard)) {
            case PLAYER_1_WINS -> {
                return true;
            }
            case PLAYER_2_WINS -> {
                return false;
            }
        }

        return player1HigherCard;
    }

    /**
     * Completes logic of the game
     * @param player1Result does player1 have such combo
     * @param player2Result does player2 have such combo
     * @param player1HigherCard does player1 have higher card than player2
     * @return Match result player1_wins, player2_wins, tie(nothing happened)
     * if player1 and player2 have same combo the player who has higher card wins.
     * if player1 has combo and player2 don't player1 wins and vice versa
     * if no-one has the combo returns TIE
     */
    private GameResult compareBooleans(boolean player1Result, boolean player2Result, boolean player1HigherCard) {
        if (player1Result || player2Result) {
            if (player1Result && !player2Result) {
                return GameResult.PLAYER_1_WINS;
            }
            if (player1Result) {
                return player1HigherCard ? GameResult.PLAYER_1_WINS : GameResult.PLAYER_2_WINS;
            }
            return GameResult.PLAYER_2_WINS;
        }
        return GameResult.TIE;
    }
    /**
     * Completes logic of the game
     * @param player1Result does player1 have such combo
     * @param player2Result does player2 have such combo
     * @param player1HigherCard does player1 have higher card than player2
     * @return Match result player1_wins, player2_wins, tie(nothing happened)
     * if player1 and player2 have same combo the player who has higher card in the combo wins. If combo value is the same player with higher card wins.
     * if player1 has combo and player2 don't player1 wins and vice versa
     * if no-one has the combo returns TIE
     */
    private GameResult compareBooleans(int player1Result, int player2Result, boolean player1HigherCard) {
        if (player1Result > 0 || player2Result > 0) {
            if (player1Result > 0 && player2Result == 0) {
                return GameResult.PLAYER_1_WINS;
            }
            if (player1Result > 0 && player2Result > 0) {
                if (player1Result == player2Result) {
                    return player1HigherCard ? GameResult.PLAYER_1_WINS : GameResult.PLAYER_2_WINS;
                }
                return player1Result > player2Result ? GameResult.PLAYER_1_WINS : GameResult.PLAYER_2_WINS;
            }
            return GameResult.PLAYER_2_WINS;
        }
        return GameResult.TIE;
    }


}
