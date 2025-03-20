package dsa.practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanEncodingTest {

    HuffmanEncoding huffmanEncoding;
    @Before
    public void setUp() throws Exception {
        huffmanEncoding = new HuffmanEncoding();
    }

    @Test
    public void getCodes() {
        huffmanEncoding.getCodes("abcdef", new int[]{5, 9, 12, 13, 16, 45});
    }
}