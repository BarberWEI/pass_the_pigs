import java.util.Scanner;

public class HumanPlayer extends Player{
    private static final String STRATEGY = "human player";
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name, STRATEGY);
    }

    
}