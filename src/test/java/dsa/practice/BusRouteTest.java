package dsa.practice;

import dsa.practice.graph.BusRoute;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusRouteTest {

    BusRoute busRoute;
    @Before
    public void setUp() throws Exception {
        busRoute = new BusRoute();
    }

    @Test
    public void numBusesToDestination() {
        int i = busRoute.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
        Assert.assertEquals(2, i);
    }

    @Test
    public void numBusesToDestination_tle() {
        int i = busRoute.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 8, 6);
        Assert.assertEquals(-1, i);
    }

    @Test
    public void numBusesToDestination_tle2() {
        int i = busRoute.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 10, 10);
        Assert.assertEquals(0, i);
    }

//    [[1,9,12,20,23,24,35,38],[10,21,24,31,32,34,37,38,43],[10,19,28,37],[8],[14,19],[11,17,23,31,41,43,44],[21,26,29,33],[5,11,33,41],[4,5,8,9,24,44]]

    @Test
    public void numBusesToDestination_complex() {
        int i = busRoute.numBusesToDestination(new int[][]{{1,9,12,20,23,24,35,38}, {10,21,24,31,32,34,37,38,43}, {10,19,28,37}, {8}, {14, 19}, {11,17,23,31,41,43,44}, {21,26,29,33}, {5,11,33,41}, {4,5,8,9,24,44}}, 37, 28);
        Assert.assertEquals(1, i);
    }
}