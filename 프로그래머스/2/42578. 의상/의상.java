import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> count = new HashMap<>();
        
        for(String[] clothe : clothes) {
            String type = clothe[1];
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        for(int c : count.values()) answer *= (c + 1);
        
        return answer - 1;
    }
}