import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int n = progresses.length;
        int[] days = new int[n];
        
        for(int i = 0; i < n; i++){
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);   
        }
        
        int prev = days[0];
        int count = 1;
        
        for(int i = 1; i < n; i++){
            if(days[i] <= prev) {
                count++;
            } else {
                answer.add(count);
                prev = days[i];
                count = 1;
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}