import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> numSets = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                numSets.add(numbers[i] + numbers[j]);
            }
        }
        
        return numSets.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }
}