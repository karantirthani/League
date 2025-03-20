package dsa.practice.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CourseScheduleTest {

    CourseSchedule courseSchedule;

    @Before
    public void setUp() throws Exception {
        courseSchedule = new CourseSchedule();
    }

    @Test
    public void checkIfPrerequisite() {
        List<Boolean> booleans = courseSchedule.checkIfPrerequisite(2, new int[][]{}, new int[][]{{1,0}, {0,1}});
        Assert.assertFalse(booleans.get(0));
        Assert.assertFalse(booleans.get(1));
    }

    @Test
    public void checkIfPrerequisite2() {
        List<Boolean> booleans = courseSchedule.checkIfPrerequisite(3, new int[][]{{1,2}, {1,0},{2,0}}, new int[][]{{1,0}, {1,2}});
        Assert.assertTrue(booleans.get(0));
        Assert.assertTrue(booleans.get(1));
    }

    @Test
    public void checkIfPrerequisite3() {
        List<Boolean> booleans = courseSchedule.checkIfPrerequisite(5, new int[][]{{0,1}, {2,3},{1,4},{3,4}}, new int[][]{{0,1}, {2,3}, {0,4}});
        Assert.assertTrue(booleans.get(0));
        Assert.assertTrue(booleans.get(1));
        Assert.assertTrue(booleans.get(2));
    }
}