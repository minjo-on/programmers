import java.util.*;

public class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0], v = path[1], w = path[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.add(new int[]{gate, 0});
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int currentIntensity = current[1];
            
            if (intensity[now] < currentIntensity) {
                continue;
            }

            if (summitSet.contains(now)) continue;

            for (int[] next : graph.get(now)) {
                int nextNode = next[0];
                int pathWeight = next[1];
                int newIntensity = Math.max(currentIntensity, pathWeight);  

                if (newIntensity < intensity[nextNode]) {
                    intensity[nextNode] = newIntensity;
                    pq.add(new int[]{nextNode, newIntensity});
                }
            }
        }

        int bestSummit = -1;
        int bestIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);  

        for (int summit : summits) {
            if (intensity[summit] < bestIntensity) {
                bestIntensity = intensity[summit];
                bestSummit = summit;
            }
        }

        return new int[]{bestSummit, bestIntensity};
    }
}
