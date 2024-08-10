import java.util.*;

public class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalGemTypes = gemTypes.size();

        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0, minEnd = 0;

        while (end < gems.length) {
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            end++;

            while (gemCount.size() == totalGemTypes) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start + 1;  
                    minEnd = end;          
                }
                
                String startGem = gems[start];
                gemCount.put(startGem, gemCount.get(startGem) - 1);
                if (gemCount.get(startGem) == 0) {
                    gemCount.remove(startGem);
                }
                start++;
            }
        }

        return new int[] {minStart, minEnd};
    }
}
