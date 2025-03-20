package dsa.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixGuardTest {

    MatrixGuard matrixGuard;
    @Before
    public void setUp() throws Exception {
        matrixGuard = new MatrixGuard();
    }

    @Test
    public void countUnguarded() {
        int i = matrixGuard.countUnguarded(6, 10, new int[][]{{0, 6}, {2, 2}, {2, 5}, {1, 2}, {4, 9}, {2, 9}, {5, 6}, {4, 6}}, new int[][]{{1, 5}});
        Assert.assertEquals(8, i);
    }
}