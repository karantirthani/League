package dsa.practice;

import dsa.practice.twopointer.Consecutive1;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class Consecutive1Test {

    Consecutive1 consecutive1 = new Consecutive1();

    @Before
    public void setUp() throws Exception {
        consecutive1 = new Consecutive1();
    }

    @Test
    public void longestOnes() {
        int i = consecutive1.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        Assert.assertEquals(6, i);
    }

    @Test
    public void longestOnes2() {
        int i = consecutive1.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        Assert.assertEquals(10, i);
    }

    //    1,1,1,0,0,0,1,1,1,1
    @Test
    public void longestOnes3() {
        int i = consecutive1.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0);
        Assert.assertEquals(4, i);
    }
}