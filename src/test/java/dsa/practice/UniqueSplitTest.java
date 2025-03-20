package dsa.practice;

import dsa.practice.recursion.backtracking.UniqueSplit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniqueSplitTest {
    UniqueSplit uniqueSplit;

    @Before
    public void setUp() throws Exception {
        uniqueSplit = new UniqueSplit();
    }

    @Test
    public void maxUniqueSplitTest() {
        int i = uniqueSplit.maxUniqueSplit("ababccc");
        Assert.assertEquals(5, i);
    }

    @Test
    public void maxUniqueSplitTest1() {
        int i = uniqueSplit.maxUniqueSplit("aba");
        Assert.assertEquals(2, i);
    }

    @Test
    public void maxUniqueSplitTest2() {
        int i = uniqueSplit.maxUniqueSplit("aa");
        Assert.assertEquals(1, i);
    }

    @Test
    public void maxUniqueSplitTest3() {
        int i = uniqueSplit.maxUniqueSplit("addbsd");
        Assert.assertEquals(5, i);
    }

//    wwwzfvedwfvhsww

    @Test
    public void maxUniqueSplitTest4() {
        int i = uniqueSplit.maxUniqueSplit("wwwzfvedwfvhsww");
        Assert.assertEquals(11, i);
    }
}