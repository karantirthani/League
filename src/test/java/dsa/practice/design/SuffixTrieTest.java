package dsa.practice.design;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SuffixTrieTest {

    SuffixTrie suffixTrie;
    @Before
    public void setUp() throws Exception {
        suffixTrie = new SuffixTrie();
    }

    @Test
    public void stringMatching() {
        List<String> matching = suffixTrie.stringMatching(new String[]{"mass", "as", "hero", "superhero"});
        Assert.assertArrayEquals(new String[]{"as","hero"}, matching.toArray());
    }
}