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
            total += frames[i].calcBallScore();
            if (frames[i].calcBallScore() == 10){
                if (frames[i].strike) {
                    if (i+1 < frames.length) {
                        total += frames[i + 1].calcBallScore();
                        if (frames[i + 1].strike && ((i + 2) < frames.length)) {
                            total += frames[i + 2].ball1;
                        } else {
                            total += frames[i + 1].ball3;
                        }
                    } else {
                        total += frames[i].calcBallScore();
                    }
                } else {
                    total += frames[i+1].ball1;
                }
            }
        }
        return total;
    }

    private void placeRollsInFrames() {
        int frameNumber = 0;
        int nextRoll = 0;

        while (frameNumber < numFrames) {
            frames[frameNumber].ball1 = rolls[nextRoll];
            if (rolls[nextRoll] != 10) {
                nextRoll++;
                frames[frameNumber].ball2 = rolls[nextRoll];
            } else {
                frames[frameNumber].strike = true;
            }
            nextRoll++;
            frameNumber++;
        }
        frames[numFrames - 1].ball3 = rolls[nextRoll];
    }

    private int[] rolls;
    private int rollNumber;
    private Frame[] frames;
    public final int numFrames = 10;
    public final int maxRolls = 21;

    private class Frame {
        public Frame() {
            score = 0;
            ball1 = 0;
            ball2 = 0;
            ball3 = 0;
            strike = false;
        }
        public int calcBallScore() {
            return (ball1 + ball2 + ball3);
        }
        public int score;
        public int ball1;
        public int ball2;
        public int ball3;
        public Boolean strike;
    }
}

