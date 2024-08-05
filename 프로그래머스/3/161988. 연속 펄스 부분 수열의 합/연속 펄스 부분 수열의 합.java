import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long plus = findMaxSum(sequence, 1);
        long minus = findMaxSum(sequence, -1);
        
        return Math.max(plus, minus);
    }

    private long findMaxSum(int[] sequence, int start) {
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;

        for (int num : sequence){
            currentSum += num * start;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) currentSum = 0;
            start *= -1;
        }
        
        return maxSum;
    }
}