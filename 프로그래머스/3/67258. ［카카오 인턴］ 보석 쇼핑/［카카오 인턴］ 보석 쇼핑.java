import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int total = gemTypes.size();
        
        Map<String, Integer> gemCount = new HashMap<>();
        int left = 0, right = 0, minLeft = 0, minRight = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(right < gems.length) {
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(gemCount.size() == total) {
                if(right - left < minLen) {
                    minLen = right - left;
                    minLeft = left + 1;
                    minRight = right;
                }
                
                String start = gems[left];
                gemCount.put(start, gemCount.get(start) - 1);
                if(gemCount.get(start) == 0) gemCount.remove(start);
                left++;
            }
        }
        
        return new int[]{minLeft, minRight};
    }
}