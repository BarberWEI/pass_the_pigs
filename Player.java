import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    private String name;
    private String strategy;
    Scanner sc = new Scanner(System.in);

    public Player(String name, String strategy) {
        this.name = name;
        this.strategy = strategy;
    }



    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        if (handScore >= 20) {
            role = false;
        }
        return role;
    }

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }
}
