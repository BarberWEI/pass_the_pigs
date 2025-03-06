import java.util.ArrayList;

class Main {
    public static final int WINNING_SCORE = 100;
    public static double average = 0;
    public static boolean printGame = true;

    public static void main(String[] args) {
        boolean won = false;
        int playerNumber = 0;

        ArrayList<Player> players = new ArrayList<>();
        // players.add(new HumanPlayer("tony"));

        // players.add(new TestBot("testBot"));
        players.add(new RiskyBotPlayerShawn("riskyBot"));
        players.add(new Linear23BotShawn("linear23Bot"));
        players.add(new ExponentialDecayBotShawn("exponentialDecayBot"));

        // players.add(new TestBot("testBot2"));
        // players.add(new RiskyBotPlayer("riskyBot2"));
        // players.add(new BestBot("bestBot2"));
        // players.add(new ExponentialDecayBot("exponentialDecayBot2"));

        PassThePigs piggy = new PassThePigs(players.size(), printGame);

        while (!won) {
            onePlayerTurn(playerNumber, players, piggy);
            displayGameStatus(players, piggy);

            if (piggy.getPlayerBank(playerNumber) >= WINNING_SCORE) {
                won = true;
                if (printGame) {
                    System.out.println("Game over! Winner is: " + players.get(playerNumber).getName());
                }
            } else {
                playerNumber = (playerNumber + 1) % players.size();
            }
        }
    }

    // runs one player's turn
    public static void onePlayerTurn(int playerNumber, ArrayList<Player> players, PassThePigs piggy) {
        boolean piggedOut = false;
        boolean passed = false;

        while (!piggedOut && !passed) {
            if (players.get(playerNumber).wantsToRoll(piggy.getPlayerBank(playerNumber), piggy.getHandValue(),
                    piggy.getPlayersBankValues(playerNumber), WINNING_SCORE)) {
                if (printGame) {
                    System.out.print(players.get(playerNumber).getName() + " rolls a ");
                }
                piggedOut = piggy.playerRolePigs(playerNumber);
            } else {
                if (printGame) {
                    System.out.println(players.get(playerNumber).getName() + " passes");
                }
                average += 1.0 / 1000000.0;
                passed = true;
            }
        }
        piggy.changePlayerBankAfterRound(playerNumber);
    }

    // Shows the current game status
    public static void displayGameStatus(ArrayList<Player> players, PassThePigs piggy) {
        if (printGame) {
            for (int i = 0; i < players.size(); i++) {
                System.out.print(players.get(i).getName() + ": " + piggy.getPlayerBank(i) + " | ");
            }
            System.out.println();
        }
    }
}
// code for testing many games to find best model
