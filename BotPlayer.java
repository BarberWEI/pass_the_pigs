import java.util.ArrayList;

public class BotPlayer extends Player{
    private static final String STRATEGY = "this bot goes for 32 because thats what i tested to be good value. however, it changes based on how close the bot is to winning, and how close opponents are to winning";
    private static final int RISK_MULTIPLIER = 1;

    public BotPlayer(String name) {
        super(name, STRATEGY);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        // through trial and error i got 32 as the quickest way to 100 on average of 10000 
        // tests repeated 3 times for all values from 1 to 35
        // also this says 20, but Idk https://www.reddit.com/r/boardgames/comments/n0ostv/a_mathematical_analysis_of_pass_the_pigs/
        if (winningScore - myScore < 23 * RISK_MULTIPLIER) {
            if (handScore >= winningScore - myScore) {
                role = false;
            }
        } else {
            role = ifNotNearWinning(otherScores, winningScore, handScore, RISK_MULTIPLIER);
        } 
        
        return role;
    }

    // method for clarity for when this bot is not near winning the game
    private boolean ifNotNearWinning ( ArrayList<Integer> otherScores, int winningScore, int handScore, int RISK_MULTIPLIER) {
        if (mostDangerousOpponnetProximity(otherScores, winningScore) < 10) {
            if (handScore >= 40 * RISK_MULTIPLIER) {
                return false;
            }
        } else if (mostDangerousOpponnetProximity(otherScores, winningScore) < 16) {
            if (handScore >= 35 * RISK_MULTIPLIER) {
                return false;
            }
        } else if (mostDangerousOpponnetProximity(otherScores, winningScore) < 22) {
            if (handScore >= 30 * RISK_MULTIPLIER) {
                return false;
            }
        } else if (handScore >= 23 * RISK_MULTIPLIER) {
            return false;
        }
        return true;
    }

    // im not good at naming but means finding the value of the smallest gap between bank score and the winning score in the opponents
    private int mostDangerousOpponnetProximity(ArrayList<Integer> otherScores, int winningScore) {
        int minDifference = winningScore - otherScores.get(0);
        for (int score : otherScores) {
            if (winningScore - score < minDifference) {
                minDifference = winningScore - score;
            } 
        }
        return minDifference;
    }
}
