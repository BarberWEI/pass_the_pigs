import java.util.ArrayList;
// this is the most successful bot that has been tested against tens of other similar bots through the testBot class, also went aginst risky and exponential bot

public class BasicBot extends BotPlayer {
    private static final String STRATEGY = "this bot goes for 23 as the target value, but when opponents are close to winning, it goes for higher values";
    private int risk;
    public BasicBot(String name, int risk) {
        super(name, STRATEGY);
        this.risk = risk;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        // through trial and error i got 32 as the quickest way to 100 on average of
        // 10000
        // tests repeated 3 times for all values from 1 to 35
        // also this says 20, but Idk
        // https://www.reddit.com/r/boardgames/comments/n0ostv/a_mathematical_analysis_of_pass_the_pigs/

        boolean role = true;
        if (winningScore - myScore < risk) {
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
        if (handScore >= risk || winningScore - handScore <= 0) {
            return false;
        }
        return true;
    }

    public String getStrategy() {
        return STRATEGY;
    }
}
