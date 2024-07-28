import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < stones.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1)  answer = Math.min(answer, stones[deque.peekFirst()]);
        }
        
        return answer;
    }
}