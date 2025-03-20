package dsa.practice;

import junit.framework.Assert;
import dsa.practice.monotonic.queue.ContinousSubarray;
import org.junit.Before;
import org.junit.Test;

public class ContinousSubarrayTest {
    ContinousSubarray continousSubarray;

    @Before
    public void setUp() throws Exception {
        continousSubarray = new ContinousSubarray();
    }

    @Test
    public void continuousSubarrays() {
        long l = continousSubarray.continuousSubarrays(new int[]{5, 4, 2, 4});
        Assert.assertEquals(8, l);
    }

    @Test
    public void continuousSubarrays2() {
        long l = continousSubarray.continuousSubarrays(new int[]{1,2,3});
        Assert.assertEquals(6, l);
    }
}