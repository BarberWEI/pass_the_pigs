import java.util.ArrayList;
// this bot is more risk taking than other bots

public class RiskyBotPlayer extends BotPlayer{
    private static final String STRATEGY = "this bot goes for 32 as the target value, but when opponents are close to winning, it goes for higher values";
    public RiskyBotPlayer(String name) {
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

    // method for clarity to choose whether or not the bot should role when the bot is not near winning. 
    // (when the score of the bot is less than 32 away from the winningScore)
    private boolean ifNotNearWinning ( ArrayList<Integer> otherScores, int winningScore, int handScore) {
        int opponentClosestToWinning = super.mostDangerousOpponnetProximity(otherScores, winningScore);
        if (opponentClosestToWinning < 5) {
            if (handScore >= 45 || winningScore - handScore  <= 0) {
                return false;
            }
        } else if (opponentClosestToWinning < 10) {
            if (handScore >= 40 || winningScore - handScore  <= 0) {
                return false;
            }
        } else if (opponentClosestToWinning < 16) {
            if (handScore >= 35 || winningScore - handScore  <= 0) {
                return false;
            }
        } else if (handScore >= 32) {
            return false;
        }
        return true;
    }
}
