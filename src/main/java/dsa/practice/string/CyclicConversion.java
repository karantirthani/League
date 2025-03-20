package dsa.practice.string;

public class CyclicConversion {
    private boolean isAllowed(char a, char b) {
        int nextOfA = (a - 'a' + 27) % 26;
        int aVal = a - 'a';
        int bVal = b - 'a';
        return bVal == nextOfA || bVal == aVal;
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        int n = str1.length();
        int m = str2.length();
        while (i < n && j<m) {
            if (isAllowed(str1.charAt(i), str2.charAt(j))) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j==m;
    }
}
