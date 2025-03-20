package dsa.practice.range;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingScheduler {
    public int getMaximumMeetings(int[] startDay, int[] endDay) {
        int n = startDay.length;
        int[][] availability = new int[n][2];
        for (int i=0; i<n; i++) {
            availability[i][0] = startDay[i];
            availability[i][1] = endDay[i];
        }
        Arrays.sort(availability, (a1, a2)-> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            }
            return a1[0] - a2[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2)-> {
            if (t1[1] == t2[1]) {
                return t1[0] - t2[0];
            }
            return t1[1] - t2[1];
        });
        int numberOfMeetings = 0;
        int curDay = 0;
        for (int i=0; i<n; i++) {
            if (pq.isEmpty()) {
                pq.offer(availability[i]);
                continue;
            }
            int start = availability[i][0];
            int end = availability[i][1];
            while (!pq.isEmpty() && start>= pq.peek()[1]) {
                int[] curTime = pq.poll();
                if (curDay< curTime[0]) {
                    curDay = curTime[0];
                } else {
                    curDay++;
                }
                numberOfMeetings++;
            }
            pq.offer(availability[i]);
        }
        while (!pq.isEmpty()) {
            int[] leftM = pq.poll();
            if (leftM[1] > curDay) {
                if (leftM[0]> curDay) {
                    curDay = leftM[0];
                } else {
                    curDay++;
                }
                numberOfMeetings++;
            }
        }
        System.out.println(numberOfMeetings);
        return numberOfMeetings;
    }
}
