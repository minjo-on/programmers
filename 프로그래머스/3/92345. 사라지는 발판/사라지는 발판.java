class Solution {
    int[] dy = new int[]{1, -1, 0, 0};
    int[] dx = new int[]{0, 0, 1, -1};
    
    class Result{
        int cnt;
        boolean canWin;

        public Result(int cnt, boolean canWin){
            this.cnt = cnt;
            this.canWin = canWin;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(board, aloc, bloc).cnt;
    }

    private Result dfs(int[][] board, int[] cloc, int[] nloc){
        if (!isMove(board, cloc)){
            return new Result(0 ,false);
        }
        
        if (cloc[0] == nloc[0] && cloc[1] == nloc[1]){
            return new Result(1, true);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean win = false;

        board[cloc[0]][cloc[1]] = 0;

        for (int i = 0; i < 4; i++){
            int[] next = new int[]{cloc[0] + dy[i], cloc[1] + dx[i]};
            if (!inRange(board, next) || board[next[0]][next[1]] == 0){
                continue;
            }

            Result nextResult = dfs(board, nloc, next);

            if (nextResult.canWin){
                max = Math.max(max, nextResult.cnt);
            }else {
                win = true;
                min = Math.min(min, nextResult.cnt);
            }
        }
        board[cloc[0]][cloc[1]] = 1;

        return new Result((win ? min : max) +1, win);
    }

    private boolean isMove(int[][] board, int[] cloc){
        for (int i = 0; i < 4; i++){
            int ny = cloc[0] + dy[i];
            int nx = cloc[1] + dx[i];
            if (inRange(board, new int[]{ny, nx}) && board[ny][nx] == 1) return true;
        }
        return false;
    }

    private boolean inRange(int[][] board, int[] cloc){
        return cloc[0] >= 0 && cloc[0] < board.length && cloc[1] >= 0 && cloc[1] < board[0].length;
    }
}