package dsa.practice;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SegmentTreeTest {

    SegmentTree segmentTree;

    @Test
    public void buildTree() {
        segmentTree = new SegmentTree(new int[] {1, 3, 5});
        System.out.println(Arrays.toString(segmentTree.segmentValues));
        segmentTree.update(0, 2);
        System.out.println(Arrays.toString(segmentTree.segmentValues));
    }

//    -28,-39,53,65,11,-56,-65,-39,-43,97

    @Test
    public void buildTree2() {
        segmentTree = new SegmentTree(new int[] {-28,-39,53,65,11,-56,-65,-39,-43,97});
        System.out.println(Arrays.toString(segmentTree.segmentValues));
        segmentTree.update(0, 2);
        System.out.println(Arrays.toString(segmentTree.segmentValues));
    }
}