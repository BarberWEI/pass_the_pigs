public class BotPlayer extends Player{
    private static final String STRATEGY = "human player";

    public BotPlayer(String name, int playerNumber) {
        super(name, STRATEGY, playerNumber);
    }
}
