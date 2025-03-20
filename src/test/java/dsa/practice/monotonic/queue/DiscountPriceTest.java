package dsa.practice.monotonic.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountPriceTest {
    DiscountPrice discountPrice;

    @Before
    public void setUp() throws Exception {
        discountPrice = new DiscountPrice();
    }

    @Test
    public void finalPrices() {
        int[] actual = discountPrice.finalPrices(new int[]{8, 4, 6, 2, 3});
        Assert.assertArrayEquals(new int[]{4,2,4,2,3}, actual);
    }
}