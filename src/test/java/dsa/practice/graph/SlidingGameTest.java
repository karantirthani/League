package dsa.practice.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingGameTest {

    SlidingGame slidingGame;
    @Before
    public void setUp() throws Exception {
        slidingGame = new SlidingGame();
    }

    @Test
    public void slidingPuzzle() {
        int i = slidingGame.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
        Assert.assertEquals(1, i);
    }

    @Test
    public void slidingPuzzle2() {
        int i = slidingGame.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}});
        Assert.assertEquals(5, i);
    }
}