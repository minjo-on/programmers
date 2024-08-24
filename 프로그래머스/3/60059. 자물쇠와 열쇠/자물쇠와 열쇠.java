class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int expandedSize = n + 2 * (m - 1);

        int[][] expandedLock = new int[expandedSize][expandedSize];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                expandedLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key);
            for (int y = 0; y <= expandedSize - m; y++) {
                for (int x = 0; x <= expandedSize - m; x++) {
                    if (unlock(y, x, key, expandedLock, n, m)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] rotateKey(int[][] key) {
        int m = key.length;
        int[][] rotatedKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[j][m - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    private boolean unlock(int y, int x, int[][] key, int[][] expandedLock, int n, int m) {
        int[][] tempLock = new int[expandedLock.length][expandedLock[0].length];
        for (int i = 0; i < expandedLock.length; i++) {
            for (int j = 0; j < expandedLock[i].length; j++) {
                tempLock[i][j] = expandedLock[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tempLock[y + i][x + j] += key[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempLock[i + m - 1][j + m - 1] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
