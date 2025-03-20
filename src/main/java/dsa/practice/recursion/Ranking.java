package dsa.practice.recursion;

public class Ranking {
    public int[] findBestSchedule(int n) {
        if (n == 2) {
            return new int[]{1,2};
        }
        int[] prevArray = findBestSchedule(n/2);
        int[] newArray = new int[n];
        int cur = n;
        for (int i=0; i<n; i=i+2) {
            newArray[i] = prevArray[i/2];
            newArray[i+1] = cur--;
        }
        return newArray;
    }
}
