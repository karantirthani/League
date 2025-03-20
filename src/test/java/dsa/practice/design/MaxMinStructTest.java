package dsa.practice.design;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxMinStructTest {

    MaxMinStruct maxMinStruct;
    @Before
    public void setUp() throws Exception {
        maxMinStruct = new MaxMinStruct();
    }

    @Test
    public void testIncrement() {
        maxMinStruct.inc("hello");
        maxMinStruct.inc("hello");
        Assert.assertEquals("hello", maxMinStruct.getMaxKey());
        maxMinStruct.inc("world");
        Assert.assertEquals("world", maxMinStruct.getMinKey());
        Assert.assertEquals("hello", maxMinStruct.getMaxKey());

    }
}