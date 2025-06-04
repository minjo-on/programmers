import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int s : scoville) queue.offer(s);
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            if(queue.peek() >= K) return count;
            
            if(queue.size() < 2) return -1;
            
            int first = queue.poll();
            int second = queue.poll();
            
            queue.offer(first + second * 2);
            count++;
        }
        
        return -1;
    }
}