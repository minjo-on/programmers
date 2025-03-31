import java.util.*;

class Solution {
    private static class Point {
        final long x, y;
        
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long A, long B, long E, long C, long D, long F) {
        long denominator = A * D - B * C;
        if (denominator == 0) return null;

        double x = (double)(B * F - E * D) / denominator;
        double y = (double)(E * C - A * F) / denominator;

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long)x, (long)y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point p = intersection(
                    line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]
                );
                if (p != null) {
                    points.add(p);
                    minX = Math.min(minX, p.x);
                    minY = Math.min(minY, p.y);
                    maxX = Math.max(maxX, p.x);
                    maxY = Math.max(maxY, p.y);
                }
            }
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] grid = new char[height][width];

        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int)(p.x - minX);
            int y = (int)(maxY - p.y);
            grid[y][x] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }
}
