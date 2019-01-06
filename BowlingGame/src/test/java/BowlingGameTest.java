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

    @Test
    public void spareAddsNextRollTwice() {
        BowlingGame game = new BowlingGame();
        game.roll(4);
        game.roll(6); //spare
        game.roll(3);
        // the rest are gutter balls
        for (int i=3; i<20; ++i)
        {
            game.roll(0);
        }
        assertEquals(16, game.score());
    }

    @Test
    public void strikeAddsNextTwoRollsTwice() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(6);
        game.roll(3);
        // the rest are gutter balls
        for (int i=3; i<20; ++i)
        {
            game.roll(0);
        }
        assertEquals(28, game.score());
    }

    @Test
    public void twoStrikesAdjacentFramesReturnsCorrectScore() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(10);
        game.roll(3);
        game.roll(6);
        // the rest are gutter balls
        for (int i=4; i<20; ++i)
        {
            game.roll(0);
        }
        assertEquals(51, game.score());
    }

    @Test
    public void perfectGameReturns300() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

    @Test
    // from website: http://slocums.homestead.com/gamescore.html
    public void completeGameReturns167() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(7);
        game.roll(3);
        game.roll(9);
        game.roll(0);
        game.roll(10);
        game.roll(0);
        game.roll(8);
        game.roll(8);
        game.roll(2);
        game.roll(0);
        game.roll(6);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(8);
        game.roll(1);
        assertEquals(167, game.score());
    }
}
