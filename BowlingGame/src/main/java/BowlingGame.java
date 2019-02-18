public class BowlingGame {

    private int[] rolls = new int[21];
    private int rollNumber = 0;
    private int theScore = 0;

    public void roll(int pins) {
        rolls[rollNumber] = pins;
        rollNumber++;
    }

    public int score() {
        scoreFrames1to9();
        scoreFrame10();
        return theScore;
    }

    private void scoreFrame10() {
        if (10 == rolls[rollNumber]) {
            handleStrike();
        } else if (10 == (rolls[rollNumber] + rolls[rollNumber + 1])) {
            handleSpare();
            addRollToScore();
        } else {
            addRollToScore();
            addRollToScore();
        }
    }

    private void scoreFrames1to9() {
        rollNumber = 0;
        int theFrame = 0;
        while (theFrame < 9) {
            if (10 == rolls[rollNumber]) {
                handleStrike();
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
    }

    private void handleSpare() {
        theScore += 10 + rolls[rollNumber + 2];
        rollNumber += 2;
    }

    private void handleStrike() {
        theScore += 10 + rolls[rollNumber + 1] + rolls[rollNumber +2];
        rollNumber++;
    }

    private void addRollToScore() {
        theScore += rolls[rollNumber];
        rollNumber++;
    }
}

