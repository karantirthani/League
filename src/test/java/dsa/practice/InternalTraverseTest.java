package dsa.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InternalTraverseTest {
    InternalTraverse internalTraverse;

    @Before
    public void setUp() throws Exception {
        internalTraverse = new InternalTraverse();

    }

    @Test
    public void findSubstring() {
        Internal root = new Internal(26);
        root.left = new Internal(5, "ABCDE");
        root.right = new Internal(21);
        root.right.left = new Internal(10, "FGHIJKLMNO");
        root.right.right = new Internal(11, "PQRSTUVWXYZ");
        String substring = internalTraverse.findSubstring(root.right, 5, 10);
        Assert.assertEquals("KLMNOPQRST", substring);
    }

    @Test
    public void findSubstring2() {
        Internal root = new Internal(26);
        root.left = new Internal(5, "ABCDE");
        root.right = new Internal(21);
        root.right.left = new Internal(10, "FGHIJKLMNO");
        root.right.right = new Internal(11, "PQRSTUVWXYZ");
        String substring = internalTraverse.findSubstring(root.right, 11, 6);
        Assert.assertEquals("QRSTUV", substring);
    }

    @Test
    public void findSubstring3() {
        Internal root = new Internal(26);
        root.left = new Internal(5, "ABCDE");
        root.right = new Internal(21);
        root.right.left = new Internal(10, "FGHIJKLMNO");
        root.right.right = new Internal(11, "PQRSTUVWXYZ");
        String substring = internalTraverse.findSubstring(root, 0, 5);
        Assert.assertEquals("ABCDE", substring);
    }

    @Test
    public void findSubstring4() {
        Internal root = new Internal(26);
        root.left = new Internal(5, "ABCDE");
        root.right = new Internal(21);
        root.right.left = new Internal(10, "FGHIJKLMNO");
        root.right.right = new Internal(11, "PQRSTUVWXYZ");
        String substring = internalTraverse.findSubstring(root, 0, 6);
        Assert.assertEquals("ABCDEF", substring);
        substring = internalTraverse.findSubstring(root, 1, 6);
        Assert.assertEquals("BCDEFG", substring);
        substring = internalTraverse.findSubstring(root, 21, 4);
        Assert.assertEquals("VWXY", substring);
    }
}