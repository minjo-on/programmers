import java.util.*;

class Solution {
     public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;
        int minFlips = Integer.MAX_VALUE;

        for (int rowMask = 0; rowMask < (1 << n); rowMask++) {
            for (int colMask = 0; colMask < (1 << m); colMask++) {
                if (canMatch(beginning, target, n, m, rowMask, colMask)) {
                    int flipCount = Integer.bitCount(rowMask) + Integer.bitCount(colMask);
                    minFlips = Math.min(minFlips, flipCount);
                }
            }
        }

        return minFlips == Integer.MAX_VALUE ? -1 : minFlips;
    }

    private boolean canMatch(int[][] beginning, int[][] target, int n, int m, int rowMask, int colMask) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = beginning[i][j];
                if ((rowMask & (1 << i)) != 0) current = 1 - current;
                if ((colMask & (1 << j)) != 0) current = 1 - current;
                if (current != target[i][j]) return false;
            }
        }
        return true;
    }
}