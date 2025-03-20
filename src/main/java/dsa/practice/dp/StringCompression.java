package dsa.practice.dp;

public class StringCompression {
    int result = Integer.MAX_VALUE;
    private int recur(int index, String s, int k, char previousCharacter, String cur, int curLen) {
        if (k<0) {
            return Integer.MAX_VALUE;
        }
        if (index == s.length()) {
            // StringBuilder x =
            // sb.append(previousCharacter);
            // sb.append(curLen);
            String finalS = cur + previousCharacter + curLen;
            System.out.println(k + " " + finalS);
            result = Math.min(result, finalS.length());
            return result;
        }
        StringBuilder sb = new StringBuilder(cur);
        if (previousCharacter ==' ' || s.charAt(index) == previousCharacter) {
            return recur(index+1, s, k, s.charAt(index), sb.toString(), curLen+1);
        } else {
            sb.append(previousCharacter);
            if (curLen>1) {
                sb.append(curLen);
            }
            return Math.min(recur(index+1, s, k-1, previousCharacter, sb.toString(), curLen) ,
                    recur(index+1, s, k, s.charAt(index), sb.toString(), 1));
        }

    }
    public int getLengthOfOptimalCompression(String s, int k) {
        //a3b1c3d1
        // O(n^2)
        result = Integer.MAX_VALUE;
        recur(0, s, k, ' ', "", 0);
        return result;
    }
}
