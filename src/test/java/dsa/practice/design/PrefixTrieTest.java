package dsa.practice.design;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixTrieTest {
    PrefixTrie prefixTrie;

    @Before
    public void setUp() throws Exception {
        prefixTrie = new PrefixTrie();
    }

    @Test
    public void prefixCount() {
        int i = prefixTrie.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at");
        Assert.assertEquals(2,i);
    }

//    "leetcode","win","loops","success"

    @Test
    public void prefixCount2() {
        int i = prefixTrie.prefixCount(new String[]{"leetcode","win","loops","success"}, "code");
        Assert.assertEquals(0,i);
    }
}