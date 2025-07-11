import java.util.*;

class Solution {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        
        tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            
            // 연결 제거
            tree[u].remove(Integer.valueOf(v));
            tree[v].remove(Integer.valueOf(u));
            
            visited = new boolean[n + 1];
            int count1 = dfs(u);
            int count2 = n - count1;
            
            minDiff = Math.min(minDiff, Math.abs(count1 - count2));
            
            // 다시 연결
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        return minDiff;
    }
    
    public int dfs(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        visited[n] = true;
        int count = 0;
        
        while(!stack.isEmpty()) {
            int current = stack.pop();
            count++;
            
            for(int neighbor : tree[current]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return count;
    }
}