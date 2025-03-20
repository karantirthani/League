package dsa.practice;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicSquareTest {

    MagicSquare magicSquare;

    @Before
    public void setUp() throws Exception {
        magicSquare = new MagicSquare();
    }

    @Test
    public void testMs() {
        int i = magicSquare.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}});
        Assert.assertEquals(1, i);
    }

    @Test
    public void testMs2() {
        int i = magicSquare.numMagicSquaresInside(new int[][]{{2,7,6},{1,5,9},{4,3,8}});
        Assert.assertEquals(0, i);
    }

    @Test
    public void testMs3() {
        int i = magicSquare.numMagicSquaresInside(new int[][]{{1,1,1},{1,1,1},{1,1,1}});
        Assert.assertEquals(0, i);
    }
}