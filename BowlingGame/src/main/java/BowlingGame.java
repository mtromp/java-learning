public class BowlingGame {

    private int[] rolls = new int[22];
    private int rollNumber = 0;
    private int theScore = 0;

    public void roll(int pins) {
        rolls[rollNumber] = pins;
        rollNumber++;
    }

    public int score() {
        rollNumber = 0;
        int theFrame = 0;
        while (theFrame < 9) {
            if (10 == rolls[rollNumber]) {
                theScore += 10 + rolls[rollNumber + 1] + rolls[rollNumber +2];
                rollNumber++;
                theFrame++;
                continue;
            }
            if (10 == (rolls[rollNumber] + rolls[rollNumber + 1])) {
                handleSpare();
                theFrame++;
                continue;
            }
            addRollToScore();
            addRollToScore();
            theFrame++;
        }
        addRollToScore();
        addRollToScore();
        return theScore;
    }

    private void handleSpare() {
        theScore += 10 + rolls[rollNumber + 2];
        rollNumber += 2;
    }

    private void addRollToScore() {
        theScore += rolls[rollNumber];
        rollNumber++;
    }
}

