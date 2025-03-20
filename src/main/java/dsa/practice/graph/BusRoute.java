package dsa.practice.graph;

import java.util.*;

public class BusRoute {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopMap = new HashMap<>();
        int n = routes.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }
        int busNo = 0;
        for (int[] route: routes) {
            for (int r : route) {
                if (!stopMap.containsKey(r)) {
                    Set<Integer> buses = new HashSet<>();
                    buses.add(busNo);
                    stopMap.put(r, buses);
                } else {
                    Set<Integer> currentBuses = stopMap.get(r);
                    for (Integer currentBus: currentBuses) {
                        graph.get(busNo).add(currentBus);
                        graph.get(currentBus).add(busNo);
                    }
                    currentBuses.add(busNo);
                }
            }
            busNo++;
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> bfs = new LinkedList<>();
        for (Integer bus : stopMap.getOrDefault(source, new HashSet<>())) {
            bfs.offer(bus);
        }
        int busCount = 1;
        while (!bfs.isEmpty()) {
            int curSize = bfs.size();
            for (int i=0; i<curSize; i++) {
                Integer currentBus = bfs.poll();
                visited.put(currentBus, true);
                if (stopMap.get(target).contains(currentBus)) {
                    return busCount;
                }
                for (Integer nextBus : graph.get(currentBus)) {
                    if (!visited.getOrDefault(nextBus, false)) {
                        bfs.offer(nextBus);
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}
