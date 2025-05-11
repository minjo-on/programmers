import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[][] dp;
    boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for(int[] edge : lighthouse) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;
        
        for(int next : graph[node]) {
            if(visited[next]) continue;
            dfs(next);
            dp[node][0] += dp[next][1];
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}