package dsa.practice.graph;

public class DSU {
    int[] parent;
    int[] rank;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return find(parent[x]);
    }

    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI != parentJ) {
            if (rank[parentI] == rank[parentJ]) {
                parent[parentJ] = parentI;
                rank[parentI]++;
            }
            else if (rank[parentI]> rank[parentJ]) {
                parent[parentJ] = parentI;
            } else {
                parent[parentI] = parentJ;
            }
        }
    }
}
