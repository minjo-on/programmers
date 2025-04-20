class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] impact = new int[n + 1][m + 1];
        
        for(int[] s : skill) {
            int type = s[0];
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            int degree = s[5] * (type == 1 ? -1 : 1);
            
            impact[y1][x1] += degree;
            impact[y1][x2 + 1] -= degree;
            impact[y2 + 1][x1] -= degree;
            impact[y2 + 1][x2 + 1] += degree;
        }
        
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                impact[i][j] += impact[i][j - 1];
            }
        }
        
        for(int i = 0; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                impact[j][i] += impact[j - 1][i];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] + impact[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}