package dsa.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumOfKSubTest {

    MaxSumOfKSub maxSumOfKSub;
    @Before
    public void setUp() throws Exception {
        maxSumOfKSub = new MaxSumOfKSub();
    }

    @Test
    public void maximumSubarraySum() {
        long l = maxSumOfKSub.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3);
        Assert.assertEquals(15, l);
    }

    //[9,9,9,1,2,3]

    @Test
    public void maximumSubarraySum2() {
        long l = maxSumOfKSub.maximumSubarraySum(new int[]{9,9,9,1,2,3}, 3);
        Assert.assertEquals(12, l);
    }


//    [11,11,7,2,9,4,17,1]

    @Test
    public void maximumSubarraySum3() {
        long l = maxSumOfKSub.maximumSubarraySum(new int[]{11,11,7,2,9,4,17,1}, 1);
        Assert.assertEquals(17, l);
    }

//    [5,3,3,1,1]
@Test
public void maximumSubarraySum4() {
    long l = maxSumOfKSub.maximumSubarraySum(new int[]{5,3,3,1,1}, 3);
    Assert.assertEquals(0, l);
}
}