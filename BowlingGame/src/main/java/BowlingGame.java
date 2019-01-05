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
        for(int i = 0; i < rolls.length; i++) {
            total += rolls[i];
        }
        return total;
    }

    private int[] rolls;
    private int rollNumber;
}
