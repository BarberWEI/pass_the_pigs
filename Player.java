import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    private String name;
    private String strategy;
    private int playerNumber;
    Scanner sc = new Scanner(System.in);

    public Player(String name, String strategy, int playerNumber) {
        this.name = name;
        this.strategy = strategy;
        this.playerNumber = playerNumber;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        return role;
    }

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }
}
