package dsa.practice.recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

public class UniqueSplit {
    Set<String> curSet;
    private int maxDfs(int index, String s) {
        if (index == s.length()) {
            return curSet.size();
        }
        int result = 0;
        for (int i=index; i<s.length(); i++) {
            String cur = s.substring(index, i+1);
            if (!curSet.contains(cur)) {
                curSet.add(cur);
                result = Math.max(result, maxDfs(i+1, s));
                curSet.remove(cur);
            }
        }
        return result;
    }
    public int maxUniqueSplit(String s) {
        curSet = new HashSet<>();
        return maxDfs(0, s);
    }
}
