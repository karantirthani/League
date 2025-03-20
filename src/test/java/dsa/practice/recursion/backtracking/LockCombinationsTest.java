package dsa.practice.recursion.backtracking;

import dsa.practice.recursion.backtracking.LockCombinations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LockCombinationsTest {

    LockCombinations lockCombinations;
    @Before
    public void setUp() throws Exception {
        lockCombinations = new LockCombinations();
    }

    @Test
    public void countNumberCombinations() {
        lockCombinations.countNumberCombinations(new int[]{0, 1, 2}, new int[]{3,4,5}, 2, 10);
    }

    @Test
    public void countNumberCombinations1() {
        int i = lockCombinations.countNumberCombinations(new int[]{1, 2, 3}, new int[]{5, 6, 7}, 2, 50);
        Assert.assertEquals(249, i);
    }
}