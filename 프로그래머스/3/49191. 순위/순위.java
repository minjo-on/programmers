import java.util.*;

public class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            graph[win][lose] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        
        
        for (int i = 1; i <= n; i++) {
            int knownResults = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != Integer.MAX_VALUE || graph[j][i] != Integer.MAX_VALUE) {
                    knownResults++;
                }
            }
            if (knownResults == n) {
                answer++;
            }
        }

        return answer;
    }
}
