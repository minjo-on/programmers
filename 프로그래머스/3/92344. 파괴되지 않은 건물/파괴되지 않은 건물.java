class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] impact = new int[n + 1][m + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5] * (type == 1 ? -1 : 1);

            impact[r1][c1] += degree;
            impact[r1][c2 + 1] -= degree;
            impact[r2 + 1][c1] -= degree;
            impact[r2 + 1][c2 + 1] += degree;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                impact[i][j] += impact[i][j - 1];
            }
        }

        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                impact[i][j] += impact[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + impact[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}