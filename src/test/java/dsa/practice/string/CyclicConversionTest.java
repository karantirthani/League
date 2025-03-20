package dsa.practice.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicConversionTest {
    CyclicConversion cyclicConversion;

    @Before
    public void setUp() throws Exception {
        cyclicConversion = new CyclicConversion();
    }

    @Test
    public void canMakeSubsequence() {
        Assert.assertTrue(cyclicConversion.canMakeSubsequence("zc", "ad"));
    }

    @Test
    public void canMakeSubsequence2() {
        Assert.assertTrue(cyclicConversion.canMakeSubsequence("abc", "ad"));
    }

    @Test
    public void canMakeSubsequence3() {
        Assert.assertFalse(cyclicConversion.canMakeSubsequence("ab", "d"));
    }

    @Test
    public void canMakeSubsequence4() {
        Assert.assertTrue(cyclicConversion.canMakeSubsequence("abc", "abc"));
    }

    @Test
    public void canMakeSubsequence5() {
        Assert.assertFalse(cyclicConversion.canMakeSubsequence("ddda", "bbba"));
    }

    @Test
    public void canMakeSubsequence6() {
        Assert.assertFalse(cyclicConversion.canMakeSubsequence("c", "b"));
    }
}