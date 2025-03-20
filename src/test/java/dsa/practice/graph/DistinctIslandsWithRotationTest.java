package dsa.practice.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctIslandsWithRotationTest {

    DistinctIslandsWithRotation distinctIslandsWithRotation;

    @Before
    public void setUp() throws Exception {
        distinctIslandsWithRotation = new DistinctIslandsWithRotation();
    }

    @Test
    public void numDistinctIslands2() {
        int i = distinctIslandsWithRotation.numDistinctIslands2(new int[][]{{1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}});
        Assert.assertEquals(1, i);
    }
}