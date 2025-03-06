import java.util.ArrayList;

public class BotPlayer extends Player {
    private String STRATEGY = "this bot goes for 23 because thats what i tested to be good value. however, it changes based on how close the bot is to winning, and how close opponents are to winning";

    public BotPlayer(String name) {
        super(name);
    }

    public BotPlayer(String name, String STRATEGY) {
        super(name);
        this.STRATEGY = STRATEGY;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        return role;
    }

    // method for clarity for when this bot is not near winning the game
    private boolean ifNotNearWinning(ArrayList<Integer> otherScores, int winningScore, int handScore) {
        return true;
    }

    // finds the value of the difference between the winning score and the highest
    // scoring opponent
    public int mostDangerousOpponnetProximity(ArrayList<Integer> otherScores, int winningScore) {
        if (otherScores.size() == 0) {
            return 1;
        }
        int minDifference = winningScore - otherScores.get(0);
        for (int score : otherScores) {
            if (winningScore - score < minDifference) {
                minDifference = winningScore - score;
            }
        }
        return minDifference;
    }

    public String getStrategy() {
        return STRATEGY;
    }
}
