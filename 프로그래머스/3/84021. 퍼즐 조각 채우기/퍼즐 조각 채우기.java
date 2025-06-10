import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        boolean[][] visited;

        // 블록과 빈 공간 추출
        List<List<Point>> blanks = extractShapes(game_board, 0);
        List<List<Point>> blocks = extractShapes(table, 1);
        boolean[] used = new boolean[blocks.size()];

        int answer = 0;
        for (List<Point> blank : blanks) {
            for (int i = 0; i < blocks.size(); i++) {
                if (used[i]) continue;

                List<Point> block = blocks.get(i);
                boolean match = false;

                for (int r = 0; r < 4; r++) {
                    block = rotate(block);
                    if (isSameShape(blank, block)) {
                        answer += blank.size();
                        used[i] = true;
                        match = true;
                        break;
                    }
                }
                if (match) break;
            }
        }
        return answer;
    }

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point other = (Point) o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private List<List<Point>> extractShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<Point>> shapes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    List<Point> shape = new ArrayList<>();
                    dfs(i, j, i, j, board, visited, shape, target);
                    normalize(shape);
                    shapes.add(shape);
                }
            }
        }
        return shapes;
    }

    private void dfs(int x, int y, int startX, int startY, int[][] board, boolean[][] visited, List<Point> shape, int target) {
        int n = board.length;
        visited[x][y] = true;
        shape.add(new Point(x - startX, y - startY));

        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] == target) {
                    dfs(nx, ny, startX, startY, board, visited, shape, target);
                }
            }
        }
    }

    private void normalize(List<Point> shape) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (Point p : shape) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        for (Point p : shape) {
            p.x -= minX;
            p.y -= minY;
        }
        shape.sort(Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));
    }

    private List<Point> rotate(List<Point> shape) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : shape) {
            rotated.add(new Point(p.y, -p.x));
        }
        normalize(rotated);
        return rotated;
    }

    private boolean isSameShape(List<Point> a, List<Point> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) return false;
        }
        return true;
    }
}
