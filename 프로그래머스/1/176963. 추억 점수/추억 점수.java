import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++){
            String[] list = photo[i];
            for (int j = 0; j < list.length; j++){
                if (map.containsKey(list[j])){
                    answer[i] += map.get(list[j]);   
                }
            }
        }
        
        return answer;
    }
}