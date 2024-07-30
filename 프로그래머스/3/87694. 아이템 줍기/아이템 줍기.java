import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int size = 102;
        boolean[][] map = new boolean[size][size];
        
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = true;
                }
            }
        }
        
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2 + 1;
            int y1 = rect[1] * 2 + 1;
            int x2 = rect[2] * 2 - 1;
            int y2 = rect[3] * 2 - 1;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = false;
                }
            }
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[size][size];
        
        queue.offer(new int[] {characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if (x == itemX * 2 && y == itemY * 2) {
                return distance / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < size && ny >= 0 && ny < size && map[nx][ny] && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny, distance + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return 0;
    }

}