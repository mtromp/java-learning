public class BowlingGame {

    public BowlingGame() {
        rollNumber = 0;
        rolls = new int[21];
        for(int i = 0; i < rolls.length; i++) {
            rolls[i] = 0;
        }
    }

    public void roll(int pins) {
        rolls[rollNumber] = pins;
        rollNumber++;
    }

    public int score() {
        int total = 0;
        int [] frames = new int[10];
        for(int i = 0; i < frames.length; i++) {
            frames[i] = 0;
        }

        int frameNumber = 0;
        for (int i = 0; i < (rolls.length / 2); i++) {
            frames[frameNumber] = rolls[i * 2];
            frames[frameNumber] += rolls[(i * 2) + 1];

            frameNumber++;
        }
        frames[9] += rolls[rolls.length - 1];

        for(int i = 0; i < frames.length; i++) {
            total += frames[i];
            if (frames[i] == 10){
                total += rolls[(i+1)*2];
            }
        }
        return total;
    }

    private int[] rolls;
    private int rollNumber;
}
