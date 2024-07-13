import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                answer += 1;
                dfs(computers, i, visited);
                //bfs(computers, i, visited);
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, int current, boolean[] visited){
        visited[current] = true;
        for (int i = 0; i < computers[current].length; i++){
            if (computers[current][i] == 1 && !visited[i]){
                dfs(computers, i, visited);
            }
        }
    }

    private void bfs(int[][] computers, int current, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        visited[current] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < computers[node].length; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}