import java.util.*;

class Solution {
     public int solution(int x, int y, int n) {
        if(x == y) return 0;
         
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(new int[]{x,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int value = current[0];
            int step = current[1];
            
            int nextValues[] = new int[]{value + n, value * 2, value * 3};
            
            for(int nextValue : nextValues){
                if(nextValue == y) return step + 1;
                
                if(nextValue < y && !visited.contains(nextValue)){
                    queue.offer(new int[]{nextValue,step + 1});
                    visited.add(nextValue);
                }
            }

        }
        return -1;
    }
}