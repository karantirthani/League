package dsa.practice;

import dsa.practice.graph.FindDivision;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDivisionTest {

    FindDivision findDivision;
    @Before
    public void setUp() throws Exception {
        findDivision = new FindDivision();
    }

    @Test
    public void calcEquation() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("a", "b"));
        input.add(Arrays.asList("b", "c"));
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        double[] output = findDivision.calcEquation(input, values, queries);
        Assert.assertEquals(6.00d, output[0]);
        Assert.assertEquals(0.50000d, output[1]);
        Assert.assertEquals(-1.0d, output[2]);
    }

    @Test
    public void calcEquation2() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("a", "e"));
        input.add(Arrays.asList("b", "e"));
        double[] values = new double[] {4.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("e", "e"));
        queries.add(Arrays.asList("x", "x"));
        double[] output = findDivision.calcEquation(input, values, queries);
        Assert.assertEquals(6.00d, output[0]);
        Assert.assertEquals(-1.0d, output[1]);
        Assert.assertEquals(-1.0d, output[2]);
    }
}