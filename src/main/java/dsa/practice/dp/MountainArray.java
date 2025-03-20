package dsa.practice.dp;

import java.util.ArrayList;

public class MountainArray {

    public int lengthOfLIS(int[] nums, int l, int r, int x) {
        if (l>r) {
            return 0;
        }
        ArrayList<Integer> sub = new ArrayList<>();

        for (int i = l; i <=r; i++) {
            int num = nums[i];
            if (sub.isEmpty()) {
                if (num<x) {
                    sub.add(num);
                }
            }
            else if (num > sub.get(sub.size() - 1) && num<x) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }

    public int lengthOfLISDec(int[] nums, int l, int r, int x) {
        if (l>r) {
            return 0;
        }
        ArrayList<Integer> sub = new ArrayList<>();

        for (int i = l; i <=r; i++) {
            int num = nums[i];
            if (sub.isEmpty()) {
                if (num<x) {
                    sub.add(num);
                }
            } else if (num < sub.get(sub.size() - 1) && num<x) {
                sub.add(num);
            } else {
                int j = binarySearchDesc(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearchDesc(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) > num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    public int lengthOfInc(int[] nums, int l, int r, int x) {
        if (l>r) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i =l; i<=r; i++) {
            if (nums[i] < x) {
                dp[i] = 1;
            }
        }
        for (int i=l; i<=r; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && nums[i]<x) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int ans = 0;
        for (int i=l; i<=r; i++) {
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public int lengthOfDec(int[] nums, int l, int r, int x) {
        int[] dp = new int[nums.length];
        for (int i =l; i<=r; i++) {
            if (nums[i]<x) {
                dp[i] = 1;
            }
        }
        for (int i=l; i<=r; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] < nums[j] && nums[i]<x) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int ans = 0;
        for (int i=l; i<=r; i++) {
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    public int minimumMountainRemovals(int[] nums) {
        // 2 4 3
        // maximum subsequence which is a mountain array
        int n = nums.length;
        int result = n;
        for (int i=0; i<n; i++) {
            int increasing = lengthOfLIS(nums, 0, i-1, nums[i]);
            int decreasing = lengthOfLISDec(nums, i+1, n-1, nums[i]);
            if (increasing == 0 || decreasing ==0) {
                continue;
            }
            result = Math.min(result, n - increasing - decreasing - 1);
        }
        return result;
    }
}
