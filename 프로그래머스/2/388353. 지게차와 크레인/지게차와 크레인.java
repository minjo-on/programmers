class Solution {
    boolean[][] visited;
    char[][] grid;
    int n, m;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] storage, String[] requests) {
        int count = 0;
        n = storage.length;
        m = storage[0].length();
        grid = new char[n][m];
        
        for(int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }
        
        for(String request : requests) {
            char target = request.charAt(0);
            visited = new boolean[n][m];
            
            if(request.length() == 2) {
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++) {
                        if(grid[i][j] == target) grid[i][j] = ' ';   
                    }
                }
            } else {
                for(int i = 0; i < n; i++) {
                    dfs(i, 0, target);
                    dfs(i, m - 1, target);
                }
                for(int j = 0; j < m; j++) {
                    dfs(0, j, target);
                    dfs(n - 1, j, target);
                }
            }   
        }
        
        int remain = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != ' ') remain++;
            }
        }

        return remain;
    }
    
    private void dfs(int y, int x, char target) {
        if (y < 0 || y >= n || x < 0 || x >= m) return;
        if (visited[y][x]) return;
        
        visited[y][x] = true;
        
        if(grid[y][x] == ' ') {
            for(int[] dir : dirs) {
                dfs(y + dir[0], x + dir[1], target);
            }
        } else if(grid[y][x] == target) {
            grid[y][x] = ' ';
        }
    }

}