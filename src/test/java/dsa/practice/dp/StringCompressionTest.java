package dsa.practice.dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    StringCompression stringCompression;
    @Before
    public void setUp() throws Exception {
        stringCompression = new StringCompression();
    }

    @Test
    public void getLengthOfOptimalCompression() {
        stringCompression.getLengthOfOptimalCompression("aaabcccd", 2);
    }
}