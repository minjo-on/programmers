import java.util.*;

class Solution {
    int[] parent;
    
    private int find(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        return find(parent[idx]);
    }

    private void union(int idx1, int idx2) {
        int root1 = find(idx1);
        int root2 = find(idx2);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }

        return answer;
    }
}