package dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfKSub {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long currentSum = 0;
        long maxSum = 0;
        Map<Integer, Integer> numbers = new HashMap<>();
        boolean isDuplicate = false;
        for (int i=0; i<n; i++) {
            if (numbers.containsKey(nums[i])) {
                isDuplicate = true;
                numbers.put(nums[i], numbers.get(nums[i]) + 1);
            } else {
                numbers.put(nums[i], 1);
            }
            currentSum = currentSum + nums[i];
            if (i>=(k-1)) {
                if (!isDuplicate) {
                    System.out.println(currentSum);
                    maxSum = Math.max(maxSum, currentSum);
                }
                int count = numbers.get(nums[i-k+1]);
                if (count == 1) {
                    numbers.remove(nums[i-k+1]);
                }
                if (count ==2) {
                    isDuplicate = false;
                }
                if (count > 1) {
                    numbers.put(nums[i-k+1], count-1);
                }
                currentSum = currentSum - nums[i-k+1];
            }
        }

        return maxSum;
    }
}
