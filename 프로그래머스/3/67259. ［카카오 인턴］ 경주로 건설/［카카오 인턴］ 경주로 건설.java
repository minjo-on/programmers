import java.util.*;

class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        for (int[][] row : cost) {
            for (int[] c : row) {
                Arrays.fill(c, Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, -1, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int dir = current[2];
            int curCost = current[3];

            for (int i = 0; i < 4; i++) {
                int ny = y + dirs[i][0];
                int nx = x + dirs[i][1];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0) {
                    int newCost = curCost + (dir == -1 || dir == i ? 100 : 600);
                    
                    if (newCost < cost[ny][nx][i]) {
                        cost[ny][nx][i] = newCost;
                        queue.add(new int[]{ny, nx, i, newCost});
                    }
                }
            }
        }

        return Arrays.stream(cost[n-1][n-1]).min().getAsInt();
    }
}
