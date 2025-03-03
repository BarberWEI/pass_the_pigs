public class PassThePigs {
//     Dot
// 34.90%
// No Dot	
// 30.20%
// Razorback
// 22.40%
// Trotter
// 8.80%
// Snouter
// 3.00%
// Leaning Jowler
// 0.70%
    public int[] getPigsStatus() {
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

}
