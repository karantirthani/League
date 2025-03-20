package dsa.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchTest {

    WordSearch wordSearch;
    @Before
    public void setUp() throws Exception {
        wordSearch = new WordSearch();
    }

    @Test
    public void findWords() {
        wordSearch.findWords(new char[][]{{'o', 'a', 'n', 'n'}, {'e','t','a','e'}, {'o', 'a', 'n', 'n'}, {'i', 'h', 'k', 'r'},{'i', 'f', 'l', 'v'}},
                new String[]{"oath","pea","eat","rain"});
    }

    @Test
    public void findWords1() {
        List<String> words = wordSearch.findWords(new char[][]{{'a', 'b'}}, new String[]{"ab"});
        Assert.assertEquals(1, words.size());
    }
}