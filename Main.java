import java.util.ArrayList;

class Main {
    public static final int WINNING_SCORE = 100;
    public static void main (String[] args) {
        int totalPlayers = 10;
        boolean won = false;
        int playerNumber = 0;
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < totalPlayers; i++) {
            players.add(new BotPlayer("tony" + i));
        }
        PassThePigs piggy = new PassThePigs(players.size());
        
        while (!won) {
            boolean piggedOut = false;
            boolean passed = false;

            while (!piggedOut && !passed) {
                if (players.get(playerNumber).wantsToRoll(piggy.getPlayerBank(playerNumber), piggy.getHandValue(), piggy.getPlayersBankValues(playerNumber) , WINNING_SCORE )) {
                    piggedOut = piggy.playerRolePigs(playerNumber);
                } else {
                    passed = true;
                }
            }
            piggy.changePlayerBankAfterRound(playerNumber);

            if (piggy.getPlayerBank(playerNumber) >= WINNING_SCORE) {
                System.out.println(players.get(playerNumber).getName() + " won");
                won = true;
            } else {
                playerNumber = (playerNumber + 1) % totalPlayers;
            }
        }
    }
}