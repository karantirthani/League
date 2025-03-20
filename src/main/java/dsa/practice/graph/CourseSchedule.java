package dsa.practice.graph;

import java.util.*;

public class CourseSchedule {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> preCourses = new HashMap<>();
        int[] indegree = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                bfs.add(i);
            }
        }

        while (!bfs.isEmpty()) {
            int n = bfs.size();
            for (int i=0; i<n; i++) {
                int top = bfs.remove();
                for (Integer child : graph.get(top)) {
                    indegree[child]--;
                    Set<Integer> childDependency = preCourses.getOrDefault(child, new HashSet<>());
                    childDependency.add(top);
                    childDependency.addAll(preCourses.getOrDefault(top, new HashSet<>()));
                    preCourses.put(child, childDependency);
                    if (indegree[child] == 0) {
                        bfs.add(child);
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(preCourses.getOrDefault(query[1], new HashSet<>()).contains(query[0]));
        }
        return result;
    }
}
