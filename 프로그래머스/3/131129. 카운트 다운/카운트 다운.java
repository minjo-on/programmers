import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] dp = new int[target + 1];
        int[] singleCount = new int[target + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        singleCount[0] = 0;

        for (int i = 1; i <= 20; i++) {
            for (int j = i; j <= target; j++) {
                if (dp[j] > dp[j - i] + 1) {
                    dp[j] = dp[j - i] + 1;
                    singleCount[j] = singleCount[j - i] + 1;
                } else if (dp[j] == dp[j - i] + 1) {
                    singleCount[j] = Math.max(singleCount[j], singleCount[j - i] + 1);
                }
            }

            for (int j = 2 * i; j <= target; j++) {
                if (dp[j] > dp[j - 2 * i] + 1) {
                    dp[j] = dp[j - 2 * i] + 1;
                    singleCount[j] = 0;
                }
            }

            for (int j = 3 * i; j <= target; j++) {
                if (dp[j] > dp[j - 3 * i] + 1) {
                    dp[j] = dp[j - 3 * i] + 1;
                    singleCount[j] = 0;
                }
            }
        }

        for (int j = 50; j <= target; j++) {
            if (dp[j] > dp[j - 50] + 1) {
                dp[j] = dp[j - 50] + 1;
                singleCount[j] = singleCount[j - 50] + 1;
            } else if (dp[j] == dp[j - 50] + 1) {
                singleCount[j] = Math.max(singleCount[j], singleCount[j - 50] + 1);
            }
        }

        return new int[]{dp[target], singleCount[target]};
    }
}