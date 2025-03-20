package dsa.practice.dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestCommonSuperTest {
    ShortestCommonSuper shortestCommonSuper;

    @Before
    public void setUp() throws Exception {
        shortestCommonSuper = new ShortestCommonSuper();
    }

    @Test
    public void shortestCommonSupersequence() {
        String s = shortestCommonSuper.shortestCommonSupersequence("bcaaacbbbcbdcaddadcacbdddcdcccdadadcbabaccbccdcdcbcaccacbbdcbabb",
                "dddbbdcbccaccbababaacbcbacdddcdabadcacddbacadabdabcdbaaabaccbdaa");
        System.out.println(s);
    }

    @Test
    public void shortestCommonSupersequence2() {
        String s = shortestCommonSuper.shortestCommonSupersequence("abac", "cab");
        System.out.println(s);
    }
}