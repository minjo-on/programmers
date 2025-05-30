import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int current = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            if(current < route[0]) {
                current = route[1];
                answer++;
            }
        }
        return answer;
    }
}