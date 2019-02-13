import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void scoreIsZeroWhenAllRollsAreZero() {
        BowlingGame game = new BowlingGame();
        for (int i=0; i<20; ++i)
        {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }
    @Test
    public void rollingNonSpareNonStrikeValuesReturnsCorrectScore()
    {
        BowlingGame game = new BowlingGame();
        for (int i=0; i<20; ++i)
        {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }
    @Test
    public void rollingSpareAddsNextRollTwice() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(5);
        for (int i=0; i<17; ++i)
        {
            game.roll(0);
        }
        assertEquals(20, game.score());
    }
}
