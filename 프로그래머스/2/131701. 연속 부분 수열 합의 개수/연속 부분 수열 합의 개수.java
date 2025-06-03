import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        int[] prefix = new int[n * 2 + 1];
        for(int i = 0; i < n * 2; i++){
            prefix[i + 1] = prefix[i] + elements[i % n];
        }
        
        Set<Integer> sums = new HashSet<>();
        
        for(int l = 1; l <= n; l++){
            for(int s = 0; s < n; s++) {
                int sum = prefix[s + l] - prefix[s];
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}