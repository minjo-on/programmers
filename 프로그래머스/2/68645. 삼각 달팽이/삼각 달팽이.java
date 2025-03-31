import java.util.*;

class Solution {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, -1}};

    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int v = 1;
        int x = 0, y = 0;
        int dir = 0;

        for (int count = 0; count < n; count++) {
            int steps = n - count;
            for (int i = 0; i < steps; i++) {
                board[y][x] = v++;
                if (i < steps - 1) {
                    y += dirs[dir][0];
                    x += dirs[dir][1];
                }
            }
            dir = (dir + 1) % 3;
            y += dirs[dir][0];
            x += dirs[dir][1];
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer.add(board[i][j]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
