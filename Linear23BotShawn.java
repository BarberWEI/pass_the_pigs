import java.util.ArrayList;
// this is the most successful bot that has been tested against tens of other similar bots through the testBot class, also went aginst risky and exponential bot

public class Linear23BotShawn extends BotPlayer {
    private static final String STRATEGY = "this bot goes for 23 as the target value, but when opponents are close to winning, it goes for higher values";

    public Linear23BotShawn(String name) {
        super(name, STRATEGY);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        // through trial and error i got 32 as the quickest way to 100 on average of
        // 10000
        // tests repeated 3 times for all values from 1 to 35
        // also this says 20, but Idk
        // https://www.reddit.com/r/boardgames/comments/n0ostv/a_mathematical_analysis_of_pass_the_pigs/

        boolean role = true;
        if (winningScore - myScore < 40) {
            if (handScore >= winningScore - myScore) {
                role = false;
            }
        } else {
            role = ifNotNearWinning(otherScores, winningScore, handScore);
        }

        return role;
    }

    // method for clarity to choose whether or not the bot should role when the bot
    // is not near winning.
    // (when the score of the bot is less than 23 away from the winningScore)
    private boolean ifNotNearWinning(ArrayList<Integer> otherScores, int winningScore, int handScore) {
        int opponentClosestToWinning = mostDangerousOpponnetProximity(otherScores, winningScore);
        int distanceFromPlayer = winningScore - opponentClosestToWinning - handScore;
        // honestly these were just randomly selected values but they work pretty well
        if (distanceFromPlayer > 40) {
            if (handScore >= 45 || winningScore - handScore <= 0) {
                return false;
            }
        } else if (distanceFromPlayer > 35) {
            if (handScore >= 40 || winningScore - handScore <= 0) {
                return false;
            }
        } else if (distanceFromPlayer > 30) {
            if (handScore >= 35 || winningScore - handScore <= 0) {
                return false;
            }
        } else if (distanceFromPlayer > 25) {
            if (handScore >= 30 || winningScore - handScore <= 0) {
                return false;
            }
        } else if (distanceFromPlayer > 20) {
            if (handScore >= 25 || winningScore - handScore <= 0) {
                return false;
            }
        } else if (handScore >= 23) {
            return false;
        }
        return true;
    }

    public String getStrategy() {
        return STRATEGY;
    }
}
