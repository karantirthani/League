package dsa.practice.graph;

import java.util.*;

public class TopologicalSort {

    // 0 -> 1 -> 2
    // 0-> 1                    0->2
    public int findChampion(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }
        int[] indegrees = new int[n];
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> sortedEdges = new ArrayList<>();

        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            sortedEdges.add(currentNode);
            System.out.println(currentNode);
            Set<Integer> children = graph.get(currentNode);
            for (Integer child: children) {
                indegrees[child]--;
                if (indegrees[child] == 0) {
                    q.add(child);
                }
            }
        }
        for (int i=1; i<n; i++) {
            int x = sortedEdges.get(i-1);
            int y = sortedEdges.get(i);
            if (!graph.get(x).contains(y)) {
                return -1;
            }
        }
        return sortedEdges.get(0);
    }
}
