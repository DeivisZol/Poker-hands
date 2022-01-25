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
                if(player1Winner) {
                    System.out.println("Winner Player 1");
                    this.player1Wins++;
                }
                else {
                    System.out.println("Winner Player 2");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean playGame() {
        boolean result = false;

        return result;
    }
}
