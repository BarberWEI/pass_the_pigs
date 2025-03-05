import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    private String name;
    private String strategy;
    private int riskFactor = 0;
    Scanner sc = new Scanner(System.in);


    public Player(String name, String strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Player(String name, String strategy, int riskFactor) {
        this.name = name;
        this.strategy = strategy;
        this.riskFactor = riskFactor;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        if (handScore >= 23 + riskFactor) {
            role = false;
        }
        // if (handScore >= 22) {
        //     role = false;
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
