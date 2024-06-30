import java.util.*;

class Solution {
    static int[] oil;

    public int solution(int[][] land) {
        int answer = 0;

        int h = land.length;
        int w = land[0].length;
        oil = new int[w];

        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, visited, i, j);
                }
            }
        }

        answer = Arrays.stream(oil).max().getAsInt();
        System.out.println(answer);
        return answer;
    }

    public void bfs(int[][] land, boolean[][] visited, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        int[][] dirs = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};

        int sum = 1;

        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            set.add(current[1]);

            for(int[] dir : dirs){
                int ny = current[0] + dir[0];
                int nx = current[1] + dir[1];

                if (ny >= 0 && ny < land.length && nx >= 0 && nx < land[0].length && land[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    sum += 1;
                }
            }
        }

        for (int index : set) {
            oil[index] += sum;
        }
    }
}