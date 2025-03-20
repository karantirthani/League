package dsa.practice;

import dsa.practice.recursion.Ranking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RankingTest {
    Ranking ranking;

    @Before
    public void setUp() throws Exception {
        int n = 8;
        ranking = new Ranking();
    }

    @Test
    public void findBestSchedule() {
        int[] bestSchedule = ranking.findBestSchedule(8);
        for (int i = 0; i < bestSchedule.length; i++) {
            System.out.print(bestSchedule[i] + " ");
        }
        Assert.assertArrayEquals(new int[]{1, 8, 4, 7, 2, 6, 3, 5}, bestSchedule);
    }

    @Test
    public void findBestSchedule2() {
        int[] bestSchedule = ranking.findBestSchedule(16);
        for (int i = 0; i < bestSchedule.length; i++) {
            System.out.print(bestSchedule[i] + " ");
        }
        Assert.assertArrayEquals(new int[]{1, 16, 8, 15, 4, 14, 7, 13, 2, 12, 6, 11, 3, 10, 5, 9}, bestSchedule);
    }

    @Test
    public void findBestSchedule3() {
        int[] bestSchedule = ranking.findBestSchedule(32);
        for (int i = 0; i < bestSchedule.length; i++) {
            System.out.print(bestSchedule[i] + " ");
        }
        Assert.assertArrayEquals(new int[]{1, 16, 8, 15, 4, 14, 7, 13, 2, 12, 6, 11, 3, 10, 5, 9}, bestSchedule);
    }
}