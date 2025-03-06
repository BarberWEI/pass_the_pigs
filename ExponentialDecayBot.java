import java.util.ArrayList;
// this bot's riskiness is based on an exponential function that is 50 when the opponnet closest to winning is 1 away from winning
// and when the opponents are 23 away from winning, the player goes for 23

public class ExponentialDecayBot extends BotPlayer {
    private static final String STRATEGY = "this bot's riskiness is based on an exponential function that is 50 when the opponnet closest to winning is 1 away from winning and when the opponents are 23 away from winning, the player goes for 23";

    public ExponentialDecayBot(String name) {
        super(name, STRATEGY);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        if (winningScore - myScore < 32) {
            if (handScore >= winningScore - myScore) {
                role = false;
            }
        } else {
            role = ifNotNearWinning(otherScores, winningScore, handScore);
        }

        return role;
    }

    private double functionForRiskinessWhenDown(int opponentClosestToWinning) {
        return 13 * Math.exp(0.0198 * opponentClosestToWinning) + 10;
    }

    // method for clarity to choose whether or not the bot should role when the bot
    // is not near winning.
    // (when the score of the bot is less than 23 away from the winningScore)
    private boolean ifNotNearWinning(ArrayList<Integer> otherScores, int winningScore, int handScore) {
        int opponentClosestToWinning = super.mostDangerousOpponnetProximity(otherScores, winningScore);
        int distanceFromPlayer = winningScore - opponentClosestToWinning - handScore;

        if (winningScore - opponentClosestToWinning > handScore) {
            if (handScore >= functionForRiskinessWhenDown(distanceFromPlayer) || winningScore - handScore <= 0) {
                return false;
            }
        } else if (handScore >= 23) {
            return false;
        }
        return true;
    }

}
