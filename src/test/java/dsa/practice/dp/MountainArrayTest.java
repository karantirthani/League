package dsa.practice.dp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class MountainArrayTest {

    MountainArray mountainArray;

    @Before
    public void setUp() throws Exception {
        mountainArray = new MountainArray();
    }

    @Test
    public void minimumMountainRemovals0() {
        int len = mountainArray.minimumMountainRemovals(new int[]{1, 3, 1});
        Assert.assertEquals(0, len);
    }

    @Test
    public void minimumMountainRemovals() {
        int len = mountainArray.minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1});
        Assert.assertEquals(3, len);
    }

    //    9,8,1,7,6,5,4,3,2,1
    // ans = 9 8   1    7    6,5,4,3,2,1
    @Test
    public void minimumMountainRemovals2() {
        int len = mountainArray.minimumMountainRemovals(new int[]{9, 8, 1, 7, 6, 5, 4, 3, 2, 1});
        Assert.assertEquals(2, len);
    }

    //    [1,2,3,4,4,3,2,1]
    @Test
    public void minimumMountainRemovals3() {
        int len = mountainArray.minimumMountainRemovals(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        Assert.assertEquals(1, len);
    }

    //[23,47,63,72,81,99,88,55,21,33,32]
    @Test
    public void minimumMountainRemovals4() {
        int len = mountainArray.minimumMountainRemovals(new int[]{23,47,63,72,81,99,88,55,21,33,32});
        Assert.assertEquals(1, len);
    }
}