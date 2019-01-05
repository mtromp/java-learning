import static org.junit.Assert.*;

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
    public void scoreIsOneWhenOneRollIsOne() {
        BowlingGame game = new BowlingGame();
        game.roll(1);
        for (int i=1; i<20; ++i)
        {
            game.roll(0);
        }
        assertEquals(1, game.score());
    }

}