package dsa.practice;

import dsa.practice.range.MeetingScheduler;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class MeetingSchedulerTest {

    MeetingScheduler meetingScheduler;
    @Before
    public void setUp() throws Exception {
        meetingScheduler = new MeetingScheduler();
    }

    @Test
    public void getMaximumMeetings() {
//        (1,2) (2, 3) (3 ,4) (3, 4) (1, 5)
        int maxMeetings = meetingScheduler.getMaximumMeetings(new int[]{1, 2, 3, 3, 1},
                new int[]{2, 3, 4, 4, 5});
        Assert.assertEquals(5, maxMeetings);
    }

    @Test
    public void getMaximumMeetings2() {
//        (1,1) (1,3) (2,3)
        int maxMeetings = meetingScheduler.getMaximumMeetings(new int[]{1, 1, 2},
                new int[]{1, 3, 3});
        Assert.assertEquals(3, maxMeetings);
    }

    @Test
    public void getMaximumMeetings3() {
//        (1,2) (2, 3) (3 ,4) (3, 4) (1, 4)
        int maxMeetings = meetingScheduler.getMaximumMeetings(new int[]{1, 2, 3, 3, 1},
                new int[]{2, 3, 4, 4, 4});
        Assert.assertEquals(4, maxMeetings);
    }

    @Test
    public void getMaximumMeetings4() {
//    (2, 3) (3, 3) (1, 4) (4, 4)
        int maxMeetings = meetingScheduler.getMaximumMeetings(new int[]{2, 3, 1, 4},
                new int[]{3, 3, 4 ,4});
        Assert.assertEquals(4, maxMeetings);
    }

    @Test
    public void getMaximumMeetings5() {
//    (1,2) (1,2)
        int maxMeetings = meetingScheduler.getMaximumMeetings(new int[]{1, 1},
                new int[]{2, 2});
        Assert.assertEquals(2, maxMeetings);
    }

    @Test
    public void getMaximumMeetings6() {
//    (1,1) (1,2) (2,2) (3,4)
        int maxMeetings = meetingScheduler.getMaximumMeetings(new int[]{1, 1, 2},
                new int[]{1, 2, 2});
        Assert.assertEquals(2, maxMeetings);
    }
}