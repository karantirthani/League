package dsa.practice.monotonic.queue;

import java.util.Stack;

public class DiscountPrice {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<int[]> mStack = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!mStack.isEmpty() && prices[i]<=mStack.peek()[1]) {
                int[] top = mStack.pop();
                int topIndex = top[0];
                int topValue = top[1];
                result[topIndex] = topValue - prices[i];
            }
            mStack.push(new int[]{i, prices[i]});
        }
        while (!mStack.isEmpty()) {
            int[] top = mStack.pop();
            int topIndex = top[0];
            int topValue = top[1];
            result[topIndex] = topValue;
        }
        return result;
    }
}
