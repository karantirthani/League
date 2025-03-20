package dsa.practice.recursion.backtracking;

import java.util.*;

public class LockCombinations {
    Set<String> patterns = new HashSet<>();
    private int combinationsRecursive(int[] pattern, int tolerance, int n, int[] current, int currentIndex) {
        if (currentIndex>= pattern.length) {
            patterns.add(Arrays.toString(current));
            return 1;
        }
        int count = 0;
        for (int i=currentIndex; i<pattern.length; i++) {
            for (int j=0; j<=tolerance; j++) {
                if ((pattern[i] + j) > n) {
                    current[i] = (pattern[i] + j)%n;
                } else {
                    current[i] = pattern[i] + j;
                }
                count = count + combinationsRecursive(pattern, tolerance, n, current, currentIndex+1);
                if ((pattern[i]-j) <= 0) {
                    current[i] = pattern[i] - j + n;
                } else {
                    current[i] = pattern[i] - j;
                }
                count = count + combinationsRecursive(pattern, tolerance, n, current, currentIndex+1);
            }
        }
        return count;
    }
    int countNumberCombinations(
            int[] user,
            int[] bypass,
            int tolerance,
            int numOptions) {
        patterns = new HashSet<>();
        int x = combinationsRecursive(user, tolerance, numOptions, new int[user.length], 0);
        int y = combinationsRecursive(bypass, tolerance, numOptions, new int[bypass.length], 0);
        System.out.println("Number of combinations: " + patterns.size());
        List<String> combinations = new ArrayList<>(patterns);
        System.out.println("Number of combinations: " + (x+y));
        return patterns.size();
    }
}
