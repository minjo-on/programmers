import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean isHighest = true;
            
            for (int[] item : queue) {
                if (item[1] > current[1]) {
                    queue.offer(current);
                    isHighest = false;
                    break;
                }
            }
            
            if (isHighest) {
                count++;
                if (current[0] == location) {
                    return count;
                }
            }
        }
        
        return -1;
    }
}