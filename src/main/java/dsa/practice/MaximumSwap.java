package dsa.practice;

public class MaximumSwap {

    public int maximumSwap(int num) {
        String numS = String.valueOf(num);
        int swapI = -1;
        int swapJ = -1;
        int maxI = -1;
        int maxNum = Integer.MIN_VALUE;

        for (int i=numS.length()-1; i>=0; i--) {
            if ((numS.charAt(i)-'0')> maxNum) {
                maxNum = numS.charAt(i) - '0';
                maxI = i;
            } else {
                if ((numS.charAt(i)-'0')!=maxNum) {
                    swapI = i;
                    swapJ = maxI;
                }

            }
        }
        StringBuilder sb = new StringBuilder(numS);
        if (swapI !=-1 && swapJ!=-1) {
            sb.setCharAt(swapI, numS.charAt(swapJ));
            sb.setCharAt(swapJ, numS.charAt(swapI));
        }
        return Integer.valueOf(sb.toString());
    }
}
