import java.util.ArrayList;

public class PassThePigs {
    private int[] playersBank;
    private static final int[] pigValue = {15, 10, 5, 5, 0, 0};
    private int handValue = 0;

    public PassThePigs(int amountOfPlayers) {
        this.playersBank = new int[amountOfPlayers];
    }

    public int getHandValue() {
        return handValue;
    }
    // returns the value of the pigs based on what type of pigs were roled
    private int valueOfPigs() {
        int[] pigStatus = getPigsStatus();
        int pig1 = pigStatus[0];
        int pig2 = pigStatus[1];
        if (pig1 + pig2 == 9) {
            return 0;
        } else if (pig1 == pig2) {
            if (pig1 == 0) {
                return 60;
            } else if (pig1 == 1) {
                return 40;
            } else if (pig1 == 2 || pig1 == 3) {
                return 20;
            } else {
                return 1;
            }
        } else {
            return pigValue[pig1] + pigValue[pig2];
        }
    }

    private int[] getPigsStatus() {
        int[] pigsStatus = {0, 0};
        pigsStatus[0] = getPigRole();
        pigsStatus[1] = getPigRole();
        return pigsStatus;
    }

    private int getPigRole() {
        if (Math.random() <= 0.007) {
            return 0;
        } else if (Math.random() <= 0.037) {
            return 1;
        } else if (Math.random() <= 0.125) {
            return 2;
        } else if (Math.random() <= 0.349) {
            return 3;
        } else if (Math.random() <= 0.651) {
            return 4;
        } else {
            return 5;
        }
    }


    // gets all player bank values
    public ArrayList<Integer> getPlayersBankValues() {
        ArrayList<Integer> banks = new ArrayList<>();
        for (int bank : playersBank) {
            banks.add(bank);
        }
        return banks;
    }

    public boolean playerRolePigs(int playerNumber) {
        int value = valueOfPigs();
        if (value != 0) {
            handValue += value;
            return false;
        } else {
            handValue = 0;
            return true;

        }
    }

    public void changePlayerBankAfterRound(int playerNumber) {
        playersBank[playerNumber] += handValue;
        handValue = 0;
    }

    public void setPlayerBank(int playerNumber, int value) {
        playersBank[playerNumber] = value;
    }

}
