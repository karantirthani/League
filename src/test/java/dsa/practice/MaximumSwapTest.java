package dsa.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumSwapTest {

    MaximumSwap maximumSwap;
    @Before
    public void setUp() throws Exception {
        maximumSwap = new MaximumSwap();
    }

    @Test
    public void maximumSwapTest() {
        int i = maximumSwap.maximumSwap(2736);
        Assert.assertEquals(7236, i);
    }

    @Test
    public void maximumSwapTest2() {
        int i = maximumSwap.maximumSwap(1993);
        Assert.assertEquals(9913, i);
    }

    @Test
    public void maximumSwapTest3() {
        int i = maximumSwap.maximumSwap(1);
        Assert.assertEquals(1, i);
    }

    @Test
    public void maximumSwapTest4() {
        int i = maximumSwap.maximumSwap(98368);
        Assert.assertEquals(98863, i);
    }

}