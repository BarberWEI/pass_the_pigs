import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private String strategy;
    private int riskFactor = 0;
    Scanner sc = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, String strategy, int riskFactor) {
        this.name = name;
        this.strategy = strategy;
        this.riskFactor = riskFactor;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = false;
        // if (handScore >= 22) {
        // role = false;
        // }
        return role;
    }

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }
}
