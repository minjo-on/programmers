import java.util.*;

class Solution {
    public int solution(int n) {
        return bfs(n , 0);
    }

    int bfs(int n, int plus){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, plus});

        int answer = 0;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int currentN = current[0];
            int currentPlus = current[1];

            if (currentN < 1 || Math.log(currentN)/Math.log(3) < (currentPlus + 1) / 2) continue;
            if (currentN == 3 && currentPlus == 2) answer += 1;

            if (currentN % 3 == 0 && currentPlus >= 2){
                queue.offer(new int[]{currentN / 3, currentPlus - 2});
            }
            queue.offer(new int[]{currentN - 1, currentPlus + 1});
        }
        return answer;
    }
}