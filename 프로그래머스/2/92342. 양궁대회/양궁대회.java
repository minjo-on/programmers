import java.util.*;

class Solution {
    List<int[]> candidates = new ArrayList<>();
    int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        
        if(candidates.isEmpty()) return new int[]{-1};
        
        candidates.sort((a, b) -> {
            for(int i = 10; i >= 0; i--) {
                if(a[i] != b[i]) return b[i] - a[i];
            }
            return 0;
        });
        
        return candidates.get(0);
    }
    
    private void dfs(int depth, int remain, int[] ryan, int[] apeach) {
        if(depth == 11) {
            if(remain > 0) ryan[10] = remain;
            
            int ryanScore = 0, apeachScore = 0;
            for(int i = 0; i < 11; i++) {
                if(ryan[i] == 0 & apeach[i] == 0) continue;
                if(ryan[i] > apeach[i]) ryanScore += (10 - i);
                else apeachScore += (10 - i);
            }
            
            int diff = ryanScore - apeachScore;
            if(diff > 0) {
                if(diff > maxDiff) {
                    maxDiff = diff;
                    candidates.clear();
                    candidates.add(ryan.clone());
                } else if (diff == maxDiff) {
                    candidates.add(ryan.clone());
                }
            }
            
            if (remain > 0) ryan[10] -= remain;
            return;
        }
        
        int need = apeach[depth] + 1;
        if(remain >= need) {
            ryan[depth] = need;
            dfs(depth + 1, remain - need, ryan, apeach);
            ryan[depth] = 0;
        }
        
        dfs(depth + 1, remain, ryan, apeach);
    }
}