public class BowlingGame {

    private int[] rolls = new int[22];
    private int rollNumber = 0;

    public void roll(int pins) {
        rolls[rollNumber] = pins;
        rollNumber++;
    }

    public int score() {
        int theScore = 0;
        int theRoll = 0;
        int theFrame = 0;
        while (theFrame < 9) {
            if (10 == (rolls[theRoll] + rolls[theRoll + 1])) {
                theScore += 10 + rolls[theRoll + 2];
                theRoll += 2;
                theFrame++;
                continue;
            }
            theScore += rolls[theRoll];
            theRoll++;
            theScore += rolls[theRoll];
            theRoll++;
            theFrame++;
        }
        theScore += rolls[theRoll];
        theRoll++;
        theScore += rolls[theRoll];
        theRoll++;
        return theScore;
    }

}

