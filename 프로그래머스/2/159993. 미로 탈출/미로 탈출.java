import java.util.*;

class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        int sy = -1, sx = -1, ly = -1, lx = -1, ey = -1, ex = -1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sy = i; sx = j;
                } else if (c == 'L') {
                    ly = i; lx = j;
                } else if (c == 'E') {
                    ey = i; ex = j;
                }
            }
        }
        
        int toLever = bfs(maps, sy, sx, ly, lx);
        int toExit = bfs(maps, ly, lx, ey , ex);
        
        if(toLever == -1 || toExit == -1) return -1;
        return toLever + toExit;
    }
    
    private int bfs(String[] maps, int sy, int sx, int ty, int tx) {
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy, sx, 0});
        visited[sy][sx] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int y = cur[0];
            int x = cur[1];
            int time = cur[2];
            
            if(y == ty && x == tx) return time;
            
            for(int d = 0; d < 4; d++) {
                int ny = y + dirs[d][0];
                int nx = x + dirs[d][1];
                
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && maps[ny].charAt(nx) != 'X'){
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx, time + 1});
                }
            }
        }
        
        return -1;
    }
}