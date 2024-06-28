import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            int subtreeSize = bfs(tree, wire[0], wire[1], visited, n);
            int diff = Math.abs((n - subtreeSize) - subtreeSize);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int bfs(List<Integer>[] tree, int start, int ignore, boolean[] visited, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : tree[node]) {
                if (neighbor == ignore || visited[neighbor]) continue;
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }

        return count;
    }
}
