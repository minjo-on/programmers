import java.util.*;

class Solution {
    private static final int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int solution(String[] board) {
        Point start = getPoint(board, 'R');

        int answer = -1;

        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()){
            Point p = queue.poll();

            if (board[p.y].charAt(p.x) == 'G'){
                return p.step;
            }

            for(int[] dir : dirs){
                int y = p.y;
                int x = p.x;

                while(y >= 0 && y < board.length && x>= 0 && x < board[0].length() && board[y].charAt(x) != 'D'){
                    y += dir[0];
                    x += dir[1];
                }

                y -= dir[0];
                x -= dir[1];

                if(!visited[y][x]){
                    queue.offer(new Point(y,x,p.step+1));
                    visited[y][x] = true;
                }
            }
        }

        return answer;
    }

    private Point getPoint(String[] board, char c){
        int y,x;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == c){
                    y = i;
                    x = j;
                    return new Point(y,x,0);
                }
            }
        }
        return new Point(-1, -1,0);
    }

    class Point{
        int y,x,step;
        Point(int y, int x, int step){
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }
}