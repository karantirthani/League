package dsa.practice;

import java.util.PriorityQueue;

class Pair<T,V> {
    T key;
    V value;

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    public Pair(T t, V v) {
        this.key = t;
        this.value = v;
    }
}
public class FillingBookcaseShelf {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = 100000;
        }
        dp[0] = 0;
        // dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // int bookWidth = books[i - 1][0];
            int bookHeight = 0;
            int curWidth = 0;
            for (int j=i-1; j>=0; j--) {
                curWidth = curWidth + books[j][0];
                if (curWidth <= shelfWidth) {
                    bookHeight = Math.max(bookHeight, books[j][1]);
                    dp[i] = Math.min(dp[i], dp[j] + bookHeight);
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }

    int MODULO = 1000000007;
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Pair<Integer, Integer>> buyOrders = new PriorityQueue<>(
                (p1, p2) -> p1.getValue().compareTo(p2.getValue()));
        PriorityQueue<Pair<Integer, Integer>> sellOrders = new PriorityQueue<>(
                (p1, p2) -> p2.getValue().compareTo(p1.getValue()));
        for (int[] order : orders) {
            int price = order[0];
            int count = order[1];
            if (order[2] == 0) {
                while (!sellOrders.isEmpty() && sellOrders.peek().getKey() <= price && count>0) {
                    Pair<Integer, Integer>  c = sellOrders.poll();

                    if (c.getValue()<=count) {
                        count = count - c.getValue();
                    } else{
                        sellOrders.add(new Pair<>(c.getKey(), c.getValue()-count));
                        count = 0;
                    }
                    System.out.println("Executed buy order for " + price + " " + count);
                }
                if (count!=0) {
                    System.out.println("Adding buy order for " + price + " " + count);
                    buyOrders.add(new Pair<>(price, count));
                }
            } else {
                while (!buyOrders.isEmpty() && buyOrders.peek().getKey() >= price && count>0) {
                    Pair<Integer, Integer>  c = buyOrders.poll();
                    if (c.getValue()<=count) {
                        count = count - c.getValue();
                    } else{
                        buyOrders.add(new Pair<>(c.getKey(), c.getValue()-count));
                        count =0;
                    }
                    System.out.println("Executed sell order for " + price + " " + count);
                }
                if (count!=0) {
                    System.out.println("Adding sell order for " + price + " " + count);
                    sellOrders.add(new Pair<>(price, count));
                }
            }
        }
        int ans = 0;
        while (!buyOrders.isEmpty()) {
            ans = (ans + buyOrders.poll().getValue()%MODULO)%MODULO;
        }
        while (!sellOrders.isEmpty()) {
            ans = (ans + sellOrders.poll().getValue()%MODULO)%MODULO;
        }
        return ans;
    }

    public int minSwaps(int[] data) {
        // Option1 move all 1 to left
        int n = data.length;
        int ans = Integer.MAX_VALUE;
        int ones = 1;
        for (int i=0; i<n; i++) {
            if (data[i] ==1) {
                ones++;
            }
        }
        int l =0, r = ones;
        int curOnes = 0;
        for (int i=l; i <r;  i++) {
            if (data[i] ==1) {
                curOnes++;
            }
        }
        while (r< n) {
            ans = Math.min(ans, ones-curOnes);
            if (data[l] ==0 && data[r]==1) {
                curOnes++;
            }
            if (data[l] == 1 && data[r] == 0) {
                curOnes--;
            }
            l++;
            r++;
        }
        return ans;
    }


}
