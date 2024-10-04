class Solution {
    public int solution(String[] board) {
        int x = 0;
        int o = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    o++;
                }else if (board[i].charAt(j) == 'X') {
                    x++;
                }
            }
        }

        if (x > o || o - x > 1) return 0;

        boolean oWins = isWinner(board, 'O');
        boolean xWins = isWinner(board, 'X');

        if (oWins && o != x + 1) {
            return 0;
        }
        if (xWins && o != x) {
            return 0;
        }

        return 1;

    }

    private boolean isWinner(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        
        return board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player;
    }
}