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
        // through trial and error i got 32 as the quickest way to 100 on average of 10000 tests repeated 3 times for all values from 1 to 35
        if (handScore >= 32) {
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
