import java.util.ArrayList;

public class BotPlayer extends Player{
    private static final String STRATEGY = "this bot goes for 32 because thats what i tested to be good value. however, it changes based on how close the bot is to winning, and how close opponents are to winning";

    public BotPlayer(String name) {
        super(name, STRATEGY);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = true;
        // through trial and error i got 32 as the quickest way to 100 on average of 10000 
        // tests repeated 3 times for all values from 1 to 35
        // this says 20, but Idk https://www.reddit.com/r/boardgames/comments/n0ostv/a_mathematical_analysis_of_pass_the_pigs/
        if (winningScore - myScore < 32) {
            if (handScore >= winningScore - myScore) {
                role = false;
            }
        } else {
            role = ifNotNearWinning(otherScores, winningScore, handScore);
        } 
        
        return role;
    }

    // method for clarity for when this bot is not near winning the game
    private boolean ifNotNearWinning ( ArrayList<Integer> otherScores, int winningScore, int handScore) {
        if (mostDangerousOpponnetProximity(otherScores, winningScore) < 10) {
            if (handScore >= 50) {
                return false;
            }
        } else if (mostDangerousOpponnetProximity(otherScores, winningScore) < 20) {
            if (handScore >= 45) {
                return false;
            }
        } else if (mostDangerousOpponnetProximity(otherScores, winningScore) < 32) {
            if (handScore >= 40) {
                return false;
            }
        } else if (handScore >= 32) {
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
