import java.util.ArrayList;

class Main {
    public static final int WINNING_SCORE = 100;
    public static void main (String[] args) {
        int totalPlayers = 10;
        boolean won = false;
        int playerNumber = 0;
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < totalPlayers - 1; i++) {
            players.add(new Player("tony " + i, "hi"));
        }
        // players.add(new HumanPlayer("tony"));
        players.add(new BotPlayer("tony21"));
        PassThePigs piggy = new PassThePigs(players.size());

        while (!won) {
            boolean piggedOut = false;
            boolean passed = false;
            onePlayerTurn(playerNumber, players, piggy);
            displayGameStatus(players, piggy);

            if (piggy.getPlayerBank(playerNumber) >= WINNING_SCORE) {
                // System.out.println(players.get(playerNumber).getName() + " won");
                won = true;
                System.out.println("Game over! Winner is: " + players.get(playerNumber).getName());
            } else {
                playerNumber = (playerNumber + 1) % totalPlayers;
            }
        } 
    } 

    // runs one player's turn
    private static void onePlayerTurn(int playerNumber, ArrayList<Player> players, PassThePigs piggy) {
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
    private static void displayGameStatus(ArrayList<Player> players, PassThePigs piggy) {
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName() + ": " + piggy.getPlayerBank(i) + " | ");
        }
        System.out.println();
    }
}