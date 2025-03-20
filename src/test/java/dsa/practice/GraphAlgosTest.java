package dsa.practice;

import dsa.practice.graph.GraphAlgos;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphAlgosTest {

    GraphAlgos graphAlgos;

    @Before
    public void setUp() throws Exception {
        graphAlgos = new GraphAlgos();
    }
    @Test
    public void countSubIslands() {
        int i = graphAlgos.countSubIslands(new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0},{1,1,0,1,1}},
                new int[][]{{1,1,1,0,0}, {0,0,1,1,1}, {0,1,0,0,0}, {1,0,1,1,0}, {0,1,0,1,0}});
        Assert.assertEquals(i, 3);
    }

    @Test
    public void countSubIslands2() {
        int i = graphAlgos.countSubIslands(new int[][]{{1,0,1,0,1}, {1,1,1,1,1}, {0,0,0,0,0}, {1,1,1,1,1},{1,0,1,0,1}},
                new int[][]{{0,0,0,0,0}, {1,1,1,1,1}, {0,1,0,1,0}, {0,1,0,1,0}, {1,0,0,0,1}});
        Assert.assertEquals(i, 2);
    }
}