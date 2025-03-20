package dsa.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSuper {
    private String shortestSupersequence(String s1, int i, String s2, int j, Map<Integer, Map<Integer, String>> memo) {
        if (i >= s1.length() && j >= s2.length()) {
            return "";
        }
        if (i >= s1.length()) {
            return s2.substring(j);
        }
        if (j >= s2.length()) {
            return s1.substring(i);
        }
        if (memo.get(i) != null && memo.get(i).get(j) != null) {
            return memo.get(i).get(j);
        }
        Map<Integer, String> newMap = new HashMap<>();
        if (s1.charAt(i) == s2.charAt(j)) {
            String common = s1.charAt(i) + shortestSupersequence(s1, i + 1, s2, j + 1, memo);
            newMap.put(j, common);
            memo.put(i, newMap);
            return memo.get(i).get(j);
        }
        String option1 = s1.charAt(i) + shortestSupersequence(s1, i + 1, s2, j, memo);
        String option2 = s2.charAt(j) + shortestSupersequence(s1, i, s2, j + 1, memo);

        if (option1.length() > option2.length()) {
            newMap.put(j, option2);
        } else {
            newMap.put(j, option1);
        }
        memo.put(i, newMap);
        return memo.get(i).get(j);
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        Map<Integer, Map<Integer, String>> memo = new HashMap<>();
        return shortestSupersequence(str1, 0, str2, 0, memo);
    }
}
