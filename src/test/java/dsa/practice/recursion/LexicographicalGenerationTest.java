package dsa.practice.recursion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class LexicographicalGenerationTest {
    LexicographicalGeneration lexicographicalGeneration;

    @Before
    public void setUp() throws Exception {
        lexicographicalGeneration = new LexicographicalGeneration();
    }

    @Test
    public void constructDistancedSequence() {
        int[] ints = lexicographicalGeneration.constructDistancedSequence(3);
        Assert.assertArrayEquals(new int[]{3,1,2,3,2}, ints);
    }

    @Test
    public void constructDistancedSequence2() {
        int[] ints = lexicographicalGeneration.constructDistancedSequence(10);
        Assert.assertArrayEquals(new int[]{3,1,2,3,2}, ints);
    }
}