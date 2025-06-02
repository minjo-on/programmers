import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) map.put(t, map.getOrDefault(t, 0) + 1);
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());
        
        int answer = 0;
        int count = 0;
        
        for(int c : counts) {
            count += c;
            answer++;
            if(count >= k) break;
        }
        
        return answer;
    }
}