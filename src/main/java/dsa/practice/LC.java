package dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class LC {

    public int subarraysDivByK(int[] nums, int k) {
        int curSum = 0;
        Map<Integer, Integer> hSet = new HashMap<>();
        hSet.put(0, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = nums[i] + curSum;
//            if (hSet.containsKey(nums[i]%k)) {
//                count++;
//            }
            if (hSet.containsKey(curSum % k)) {
                count++;
            } else {
                hSet.put(curSum % k, i);
            }

        }

        return count;
    }
}
