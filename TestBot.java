import java.util.ArrayList;
// this bot is used for testing successful bots against new ideas

public class TestBot extends BotPlayer {
    private static final String STRATEGY = "this is a test";

    public TestBot(String name) {
        super(name, STRATEGY);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        if (winningScore - myScore < 23) {
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

        // New adjusted values within ±5 range
        if (opponentClosestToWinning < 7) { // Was <5
            if (handScore >= 52 || winningScore - handScore <= 0) { // Was 50
                return false;
            }
        } else if (opponentClosestToWinning < 12) { // Was <10
            if (handScore >= 47 || winningScore - handScore <= 0) { // Was 45
                return false;
            }
        } else if (opponentClosestToWinning < 17) { // Was <15
            if (handScore >= 42 || winningScore - handScore <= 0) { // Was 40
                return false;
            }
        } else if (opponentClosestToWinning < 22) { // Was <20
            if (handScore >= 37 || winningScore - handScore <= 0) { // Was 35
                return false;
            }
        } else if (opponentClosestToWinning < 27) { // Was <25
            if (handScore >= 32 || winningScore - handScore <= 0) { // Was 30
                return false;
            }
        } else if (handScore >= 25) { // Was 23
            return false;
        }
        return true;
    }

}
