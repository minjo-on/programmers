import java.util.*;

class Solution {
    private int[][][] dp;
    private int[][] info;
    private int n, m, size;
    private final int INF = Integer.MAX_VALUE;
    
    public int solution(int[][] info, int n, int m) {
        this.info = info;
        this.n = n;
        this.m = m;
        this.size = info.length;
        
        dp = new int[size + 1][n][m];
        for(int[][] arr : dp) {
            for(int[] ar : arr) Arrays.fill(ar, -1);
        }
        
        int answer = dfs(0, 0, 0);
        return answer >= INF ? -1 : answer;
    }
    
    private int dfs(int idx, int a, int b) {
        if(a >= n || b >= m) return INF;
        if(idx == size) return 0;
        
        if(dp[idx][a][b] != -1) return dp[idx][a][b];
        
        int na = dfs(idx + 1, a + info[idx][0], b);
        if(na < INF) na += info[idx][0];
        
        int nb = dfs(idx + 1, a, b + info[idx][1]);
            
        return dp[idx][a][b] = Math.min(na, nb);
    }
}