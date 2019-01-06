public class BowlingGame {

    public BowlingGame() {
        rollNumber = 0;
        rolls = new int[maxRolls];
        for(int i = 0; i < rolls.length; i++) {
            rolls[i] = 0;
        }
        frames = new Frame[numFrames];
        for(int i = 0; i < numFrames ; i++)
        {
            frames[i] = new Frame();
        }
    }

    public void roll(int pins) {
        rolls[rollNumber] = pins;
        rollNumber++;
    }

    public int score() {
        int total = 0;

        placeRollsInFrames();

        for(int i = 0; i < frames.length; i++) {
            total += frames[i].score;
            if (frames[i].score == 10){
                if (frames[i].strike) {
                    total += frames[i+1].score;
                } else {
                    total += rolls[(i + 1) * 2];
                }
            }
        }
        return total;
    }

    private void placeRollsInFrames() {
        int frameNumber = 0;
        int nextRoll = 0;
        for (int i = 0; i < (rolls.length / 2); i++) {

            frames[frameNumber].score = rolls[nextRoll];
            if (frames[frameNumber].score != 10) {
                nextRoll++;
                frames[frameNumber].score += rolls[nextRoll];
            } else {
                frames[frameNumber].strike = true;
            }
            nextRoll++;
            frameNumber++;
        }
        frames[9].score += rolls[rolls.length - 1];
    }

    private int[] rolls;
    private int rollNumber;
    private Frame[] frames;
    public final int numFrames = 10;
    public final int maxRolls = 21;

    private class Frame {
        public Frame() {
            score = 0;
            strike = false;
        }
        public int score;
        public Boolean strike;
    }
}

