import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            adjList.get(fare[0]).add(new int[]{fare[1], fare[2]});
            adjList.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }

        int[] distanceFromS = dijkstra(n, s, adjList);

        int answer = Integer.MAX_VALUE;
        for (int via = 1; via <= n; via++) {
            if (distanceFromS[via] != Integer.MAX_VALUE) {
                int[] distanceFromVia = dijkstra(n, via, adjList);
                int totalCost = distanceFromS[via] + distanceFromVia[a] + distanceFromVia[b];
                answer = Math.min(answer, totalCost);
            }
        }

        return answer;
    }

    private int[] dijkstra(int n, int start, List<List<int[]>> adjList) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentPosition = current[0];
            int currentCost = current[1];

            if (currentCost > distance[currentPosition]) continue;

            for (int[] next : adjList.get(currentPosition)) {
                int nextPosition = next[0];
                int nextCost = next[1];
                if (distance[nextPosition] > currentCost + nextCost) {
                    distance[nextPosition] = currentCost + nextCost;
                    pq.offer(new int[]{nextPosition, distance[nextPosition]});
                }
            }
        }

        return distance;
    }
}