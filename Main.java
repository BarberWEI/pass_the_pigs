import java.util.ArrayList;

class Main {
    public static final int WINNING_SCORE = 100;
    public static void main (String[] args) {
        int totalPlayers = 2;
        boolean won = false;
        int playerNumber = 0;
        ArrayList<Player> players = new ArrayList<>();
        // players.add(new HumanPlayer("tony"));

        players.add(new BestBot("tony1"));
        players.add(new TestBot("tony2"));
        PassThePigs piggy = new PassThePigs(players.size());

        while (!won) {
            onePlayerTurn(playerNumber, players, piggy);
            displayGameStatus(players, piggy);

            if (piggy.getPlayerBank(playerNumber) >= WINNING_SCORE) {
                won = true;
                System.out.println("Game over! Winner is: " + players.get(playerNumber).getName());
            } else {
                playerNumber = (playerNumber + 1) % totalPlayers;
            }
        }  
    } 

    // runs one player's turn
    public static void onePlayerTurn(int playerNumber, ArrayList<Player> players, PassThePigs piggy) {
        boolean piggedOut = false;
        boolean passed = false;

        while (!piggedOut && !passed) {
            if (players.get(playerNumber).wantsToRoll(piggy.getPlayerBank(playerNumber), piggy.getHandValue(), piggy.getPlayersBankValues(playerNumber), WINNING_SCORE)) {     
                System.out.print(players.get(playerNumber).getName() + " rolls a "); 
                piggedOut = piggy.playerRolePigs(playerNumber);
            } else {
                System.out.println(players.get(playerNumber).getName() + " passes");
                passed = true;
            }
        }
        piggy.changePlayerBankAfterRound(playerNumber);
    }

    // Shows the current game status
    public static void displayGameStatus(ArrayList<Player> players, PassThePigs piggy) {
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName() + ": " + piggy.getPlayerBank(i) + " | ");
        }
        System.out.println();
    }
}
// code for testing many games to find best model
    // int[] whoWon = new int[totalPlayers];

    // for (int i = 0; i < 100000; i++) {
    //     playerNumber = 0;
    //     won = false;
    //     for (int j = 0; j < totalPlayers; j++) {
    //         piggy.setPlayerBank(j, 0);
    //     }
    // }
    // for (int who : whoWon) {
    //     System.out.print(who + " ");
    // }
    //whoWon[playerNumber]++;