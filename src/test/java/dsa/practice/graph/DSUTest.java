package dsa.practice.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DSUTest {
    DSU dsu;

    @Before
    public void setUp() throws Exception {
        dsu = new DSU(4);
    }

    @Test
    public void testUnion() {
        dsu = new DSU(4);
        dsu.union(0,1);
        dsu.union(2, 3);
        System.out.println(Arrays.toString(dsu.parent));
        System.out.println(Arrays.toString(dsu.rank));
        dsu.union(0, 3);
        System.out.println("After union");
        System.out.println(Arrays.toString(dsu.parent));
        System.out.println(Arrays.toString(dsu.rank));
//        dsu.find(3);
//        System.out.println("After find");
//        System.out.println(Arrays.toString(dsu.parent));
//        System.out.println(Arrays.toString(dsu.rank));
    }

    @Test
    public void testUnion2() {
        dsu = new DSU(6);
        dsu.union(0,1);
        dsu.union(2, 3);
        dsu.union(3, 4);
        dsu.union(4, 5);
        System.out.println(Arrays.toString(dsu.parent));
        System.out.println(Arrays.toString(dsu.rank));
        dsu.union(0, 3);
        System.out.println("After union");
        System.out.println(Arrays.toString(dsu.parent));
        System.out.println(Arrays.toString(dsu.rank));
        dsu.find(4);
        System.out.println("After find");
        System.out.println(Arrays.toString(dsu.parent));
        System.out.println(Arrays.toString(dsu.rank));
    }
}