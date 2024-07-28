import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;

        int result1 = rob(money, 0, n - 2);
        int result2 = rob(money, 1, n - 1);

        return Math.max(result1, result2);
    }

    private int rob(int[] houses, int start, int end) {
        int len = end - start + 1;

        int[] dp = new int[len];
        dp[0] = houses[start];
        dp[1] = Math.max(houses[start], houses[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[start + i]);
        }

        return dp[len - 1];
    }
}