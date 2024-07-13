import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(Arrays.stream(works).boxed().collect(Collectors.toList()));

        while (n > 0) {
            if (!pq.isEmpty()) {
                int max = pq.poll();
                if (max > 0) {
                    pq.add(max - 1);
                }
            }
            n--;
        }

        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}