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
                if (players.get(playerNumber).wantsToRoll(piggy.getPlayersBankValues().get(playerNumber), piggy.getHandValue(), piggy.getPlayersBankValues() , WINNING_SCORE )) {
                    piggedOut = piggy.playerRolePigs(playerNumber);
                }else {
                    passed = true;
                }
            }

            piggy.changePlayerBankAfterRound(playerNumber);

            if (piggy.getPlayersBankValues().get(playerNumber) >= WINNING_SCORE) {
                System.out.println(piggy.getPlayersBankValues().get(playerNumber) + players.get(playerNumber).getName());
                won = true;
            } else {
                playerNumber = (playerNumber + 1) % totalPlayers;
            }


        }
    }
}