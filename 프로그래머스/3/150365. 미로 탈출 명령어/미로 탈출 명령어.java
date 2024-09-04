class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dir = {"d", "l", "r", "u"};
    static String result = "impossible";
    static boolean found = false;

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(r - x) + Math.abs(c - y);

        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        backtrack(n, m, x, y, r, c, k, "");

        return result;
    }

    public static void backtrack(int n, int m, int x, int y, int r, int c, int k, String path) {
        if (found) return;
        if (k == 0) {
            if (x == r && y == c) {
                result = path;
                found = true;
            }
            return;
        }
        
        int remainingDistance = Math.abs(r - x) + Math.abs(c - y);

        if (remainingDistance > k || (k - remainingDistance) % 2 != 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                backtrack(n, m, nx, ny, r, c, k - 1, path + dir[i]);
            }
        }
    }
}