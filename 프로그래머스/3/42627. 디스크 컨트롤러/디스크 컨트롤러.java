import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int total = 0;
        int jobIdx = 0;
        int second = 0;
        
        Arrays.sort(jobs, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));
        
        while(!queue.isEmpty() || jobIdx < jobs.length){
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= second) {
                queue.offer(jobs[jobIdx++]);
            }
            
            if(queue.isEmpty()) {
                second = jobs[jobIdx][0];
            } else {
                int[] current = queue.poll();
                second += current[1];
                total += second - current[0];
            }
            
        }
        
        return total / jobs.length;
    }
}