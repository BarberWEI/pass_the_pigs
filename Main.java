import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Main {
    public static final int WINNING_SCORE = 100;
    public static double average = 0;
    public static void main(String[] args) {
        boolean won = false;
        int playerNumber = 0;
        ArrayList<Player> players = new ArrayList<>();
        // players.add(new HumanPlayer("tony"));


        players.add(new TestBot("testBot"));
        players.add(new RiskyBotPlayer("riskyBot"));
        players.add(new BestBot("bestBot"));
        players.add(new ExponentialDecayBot("exponentialDecayBot"));
        // players.add(new TestBot("testBot2"));
        // players.add(new RiskyBotPlayer("riskyBot2"));
        // players.add(new BestBot("bestBot2"));
        // players.add(new ExponentialDecayBot("exponentialDecayBot2"));

        PassThePigs piggy = new PassThePigs(players.size());

        ArrayList<Integer> whoWon = new ArrayList<>();
        for(int i = 0; i < players.size(); i++) {
            whoWon.add(0);
        }

        for (int i = 0; i < 1000000; i++) {
        
            playerNumber = 0;
            won = false;
            for (int j = 0; j < players.size(); j++) {
                piggy.setPlayerBank(j, 0);
            }
            shufflePlayers(players, whoWon);

            while (!won) {
                onePlayerTurn(playerNumber, players, piggy);
                displayGameStatus(players, piggy);

                if (piggy.getPlayerBank(playerNumber) >= WINNING_SCORE) {
                    whoWon.set(playerNumber, whoWon.get(playerNumber) + 1);
                    won = true;
                    //System.out.println("Game over! Winner is: " + players.get(playerNumber).getName());
                } else {
                    playerNumber = (playerNumber + 1) % players.size();
                }
            }
        }
        System.out.println(average);
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName() + " got " + whoWon.get(i) + " ");
        }
    }

    // runs one player's turn
    public static void onePlayerTurn(int playerNumber, ArrayList<Player> players, PassThePigs piggy) {
        boolean piggedOut = false;
        boolean passed = false;

        while (!piggedOut && !passed) {
            if (players.get(playerNumber).wantsToRoll(piggy.getPlayerBank(playerNumber), piggy.getHandValue(),
                piggy.getPlayersBankValues(playerNumber), WINNING_SCORE)) {
                //System.out.print(players.get(playerNumber).getName() + " rolls a ");
                piggedOut = piggy.playerRolePigs(playerNumber);
            } else {
                //System.out.println(players.get(playerNumber).getName() + " passes");
                average += 1.0/1000000.0;
                passed = true;
            }
        }
        piggy.changePlayerBankAfterRound(playerNumber);
    }

    // Shows the current game status
    public static void displayGameStatus(ArrayList<Player> players, PassThePigs piggy) {
        for (int i = 0; i < players.size(); i++) {
            //System.out.print(players.get(i).getName() + ": " + piggy.getPlayerBank(i) + " | ");
        }
        //System.out.println();
    }
    
    public static void shufflePlayers(ArrayList<Player> players, ArrayList<Integer> whoWon) {
        Random r1 = new Random(); 
  
        for (int i = players.size() - 1; i >= 1; i--) { 
            int j = r1.nextInt(i + 1);

            Collections.swap(players, i, j); 
            Collections.swap(whoWon, i, j); 
        } 
    }

}
// code for testing many games to find best model

