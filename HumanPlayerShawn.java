import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayerShawn extends Player {
    private static final String STRATEGY = "human player";
    Scanner sc = new Scanner(System.in);

    public HumanPlayerShawn(String name) {
        super(name);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        boolean role = false;
        System.out.println("dear " + getName() + " your handscore is: " + handScore + " your bank is: " + myScore
                + " the winning score is: " + winningScore + " your opponents have bank values of " + otherScores
                + " would you like to role the pigs？");
        System.out.println("y/n");
        String input = sc.nextLine();
        input = repeatUntilValidInput(input);
        if (input.equals("y")) {
            role = true;
        } else {
            role = false;
        }
        return role;
    }

    // repeats asking player to input y or n until a valid input is given
    private String repeatUntilValidInput(String input) {
        String tempInput = input;
        while (!(tempInput.equals("n")) && !(tempInput.equals("y"))) {
            System.out.println("y/n");
            tempInput = sc.nextLine();
        }
        return tempInput;
    }

    public String getStrategy() {
        return STRATEGY;
    }
}