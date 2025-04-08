import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance + 1;
        int answer = 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(isValid(mid, rocks, n)){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean isValid(int mid, int[] rocks, int n){
        int removed = 0;
        int prev = 0;
        
        for(int rock : rocks){
            if(rock - prev < mid){
                removed++;
                if(removed > n) return false;
                continue;
            }
            prev = rock;
        }
        
        return true;
    }
}