package dsa.practice.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopologicalSortTest {

    TopologicalSort topologicalSort;

    @Before
    public void setUp() throws Exception {
        topologicalSort = new TopologicalSort();
    }

    @Test
    public void findChampion() {
        int champion = topologicalSort.findChampion(3, new int[][]{{0, 1}, {1, 2}});
        Assert.assertEquals(0, champion);
    }

    //    [[0,2],[1,3],[1,2]]
    @Test
    public void findChampion2() {
        int champion = topologicalSort.findChampion(4, new int[][]{{0, 2}, {1, 3},{1,2}});
        Assert.assertEquals(-1, champion);
    }
}