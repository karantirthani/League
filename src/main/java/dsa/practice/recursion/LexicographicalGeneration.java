package dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalGeneration {
    private boolean constructRecur(boolean[] used, int n, int[] result, int curIndex) {
        if (curIndex == result.length) {
            return true;
        }
        if (result[curIndex] != 0) {
            return constructRecur(used, n, result, curIndex + 1);
        }

        for (int i = n; i >= 1; i--) {

            if (!used[i]) {
                used[i] = true;
                result[curIndex] = i;
                if (i == 1) {
                    if (constructRecur(used, n, result, curIndex + 1)) {
                        return true;
                    }
                } else {
                    int j = curIndex + i;
                    if (j < result.length && result[j] == 0) {
                        result[j] = i;
                        if (constructRecur(used, n, result, curIndex + 1)) {
                            return true;
                        }
                        result[j] = 0;
                    }
                }
                used[i] = false;
                result[curIndex] = 0;
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[20];
        int[] result = new int[n * 2 - 1];
        constructRecur(used, n, result, 0);
        return result;
    }
}
