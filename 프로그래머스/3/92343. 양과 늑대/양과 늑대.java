import java.util.*;

class Solution {
    int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        List<Integer>[] tree = new ArrayList[info.length];
        
        for(int i = 0; i < info.length; i++) tree[i] = new ArrayList<>();
        
        for(int[] edge : edges) tree[edge[0]].add(edge[1]);
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        
        dfs(0, 0, 0, tree, nextNodes, info);
        
        return maxSheep;
    }
    
    private void dfs(int node, int s, int w, List<Integer>[] tree, List<Integer> nextNodes, int[] info) {
        if(info[node] == 0) s++;
        else w++;
        
        if(w >= s) return;
        
        maxSheep = Math.max(maxSheep, s);
        
        List<Integer> next = new ArrayList<>(nextNodes);
        next.remove(Integer.valueOf(node));
        next.addAll(tree[node]);
        
        for(int n : next) dfs(n, s, w, tree, next, info);
    }
}