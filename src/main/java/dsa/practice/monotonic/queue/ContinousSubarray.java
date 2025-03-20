package dsa.practice.monotonic.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ContinousSubarray {

    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minDq = new ArrayDeque<>();
        Deque<Integer> maxDq = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int n = nums.length;
        long result = 0;
        while (r < n) {
            while (!minDq.isEmpty() && nums[minDq.peekLast()] > nums[r]) {
                minDq.pollLast();
            }
            while (!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[r]) {
                maxDq.pollLast();
            }
            minDq.offerLast(r);
            maxDq.offerLast(r);
            if (Math.abs(nums[maxDq.peekFirst()] - nums[minDq.peekFirst()]) <= 2) {
                result = result + (r - l + 1);
                r++;
            } else {
                l++;
                while (!minDq.isEmpty() && l > minDq.peekFirst()) {
                    minDq.pollFirst();
                }
                while (!maxDq.isEmpty() && l > maxDq.peekFirst()) {
                    maxDq.pollFirst();
                }
            }
        }
        return result;
    }
}
