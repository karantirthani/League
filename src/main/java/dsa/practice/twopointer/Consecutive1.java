package dsa.practice.twopointer;

public class Consecutive1 {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int used = 0;
        int maxWindow = 0;
        int lastZero = 0;
        while (l<=r && r < n) {
            if (nums[r] == 1) {
                maxWindow = Math.max(maxWindow, r - l + 1);
                r++;
                System.out.println(l + " " + r);
            } else if (nums[r] == 0 && used < k) {
                used++;
                maxWindow = Math.max(maxWindow, r - l + 1);
                r++;
                System.out.println(l + " " + r);
            } else {
                // nums[r] is 0
                if (nums[l] != 0) {
                    while ((l + 1) < r && nums[l] != 0) {
                        l++;
                    }
                }
                l = Math.min(l+1, r);
                r++;
                used = Math.max(used-1, 0);
            }
        }
        return maxWindow;
    }
}
