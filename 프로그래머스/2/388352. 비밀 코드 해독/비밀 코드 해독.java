import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int result = 0;
        
        List<int[]> combinations = new ArrayList<>();
        generateComb(1, n, new int[5], 0, combinations);
        
        for(int[] comb : combinations) {
            boolean isValid = true;
            Set<Integer> combSet = new HashSet<>();
            for(int num : comb) combSet.add(num);
            
            for(int i = 0; i < q.length; i++) {
                int match = 0;
                for(int num : q[i]) {
                    if(combSet.contains(num)) match++;
                }
                if(match != ans[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) result++;
        }
        
        return result;
    }
    
    private void generateComb(int start, int n, int[] temp, int depth, List<int[]> combinations) {
        if(depth == 5) {
            combinations.add(Arrays.copyOf(temp, 5));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            temp[depth] = i;
            generateComb(i + 1, n, temp, depth + 1, combinations);
        }
    }
}