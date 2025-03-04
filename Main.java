import java.util.ArrayList;

class Main {
    public static void main (String[] args) {
        int totalPlayers = 1;
        boolean won = false;
        int playerNumber = 0;
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new BotPlayer("tony", 0));
        PassThePigs piggy = new PassThePigs(players.size());
        while (!won) {
            if (players[playerNumber].wantsToRoll()) {
                
            }
            playerNumber++;
            playerNumber = playerNumber % totalPlayers;
        }
    }
}