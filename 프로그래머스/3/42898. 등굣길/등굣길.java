import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        boolean[][] puddleMap = new boolean[n][m];
        
        for (int[] puddle : puddles) puddleMap[puddle[1] - 1][puddle[0] - 1] = true;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(puddleMap[i][j]){
                    dp[i][j] = 0;
                } else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = ((i > 0 ? dp[i - 1][j] : 0) + 
                                (j > 0 ? dp[i][j - 1] : 0)) % 1000000007;
                }
            }
        }

        return dp[n-1][m-1];
    }
}