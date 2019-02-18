import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

    BowlingGame game;

    private void multipleRolls(int numRolls, int numPins) {
        for (int i = 0; i < numRolls; i++) {
            game.roll(numPins);
        }
    }

    @Before
    public void setup() {
        game = new BowlingGame();
    }

    @Test
    public void scoreIsZeroWhenAllRollsAreZero() {
        multipleRolls(20, 0);
        assertEquals(0, game.score());
    }
    @Test
    public void rollingNonSpareNonStrikeValuesReturnsCorrectScore()
    {
        multipleRolls(20, 1);
        assertEquals(20, game.score());
    }
    @Test
    public void rollingSpareAddsNextRollTwice() {
        multipleRolls(3, 5);
        multipleRolls(17, 0);
        assertEquals(20, game.score());
    }
    @Test
    public void rollingStrikesAddsNextTwoRollsTwice() {
        game.roll(10);
        multipleRolls(2, 5);
        multipleRolls(17, 0);
        assertEquals(30, game.score());
    }
    @Test
    public void rollingPerfectGameReturns300() {
        multipleRolls(12, 10);
        assertEquals(300, game.score());
    }
    @Test
    public void rollingSpareInTenthFrameIsScoredCorrectly() {
        multipleRolls(18, 2);
        multipleRolls(3,5);
        assertEquals(56, game.score());
    }
}
