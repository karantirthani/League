package dsa.practice.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraTest {

    Dijkstra dijkstra;
    @Before
    public void setUp() throws Exception {
        dijkstra = new Dijkstra();
    }

    @Test
    public void minCost() {
        int minCost = dijkstra.minCost(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}});
        Assert.assertEquals(3, minCost);
    }

    @Test
    public void minCost2() {
        int minCost = dijkstra.minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}});
        Assert.assertEquals(0, minCost);
    }

    @Test
    public void minCost3() {
        int minCost = dijkstra.minCost(new int[][]{{1, 2}, {4, 3}});
        Assert.assertEquals(1, minCost);
    }
}