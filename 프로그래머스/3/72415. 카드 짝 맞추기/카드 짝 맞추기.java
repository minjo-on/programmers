import java.util.*;

class Solution {
    List<int[]> permutations = new ArrayList<>();
    
    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int cardCount = 0;
        Map<Integer, List<int[]>> cardPositions = new HashMap<>();

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] != 0) {
                    cardPositions.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
                    cardCount++;
                }
            }
        }
        cardCount /= 2;

        int[] cardNumbers = new int[cardCount];
        int idx = 0;
        for (int key : cardPositions.keySet()) {
            cardNumbers[idx++] = key;
        }

        generatePermutations(cardNumbers, 0);

        for (int[] perm : permutations) {
            int[][] copy = new int[4][4];
            for(int i = 0; i < 4; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, 4);
            }

            int totalMoves = 0;
            int y = r;
            int x = c;

            for (int target : perm) {
                List<int[]> positions = cardPositions.get(target);

                int[] firstPos = positions.get(0);
                int[] secondPos = positions.get(1);

                int[] result1 = bfs(y, x, firstPos, copy);
                int[] result2 = bfs(y, x, secondPos, copy);

                if (result1[2] + bfs(result1[0], result1[1], secondPos, copy)[2] <= result2[2] + bfs(result2[0], result2[1], firstPos, copy)[2]) {
                    totalMoves += result1[2];
                    y = firstPos[0];
                    x = firstPos[1];
                    copy[y][x] = 0;

                    totalMoves += bfs(y, x, secondPos, copy)[2];
                    y = secondPos[0];
                    x = secondPos[1];
                    copy[y][x] = 0;
                } else {
                    totalMoves += result2[2];
                    y = secondPos[0];
                    x = secondPos[1];
                    copy[y][x] = 0;

                    totalMoves += bfs(y, x, firstPos, copy)[2];
                    y = firstPos[0];
                    x = firstPos[1];
                    copy[y][x] = 0;
                }

                totalMoves += 2;
            }
            answer = Math.min(answer, totalMoves);
        }

        return answer;
    }

    private void generatePermutations(int[] cardNumbers, int start) {
        if (start == cardNumbers.length) {
            permutations.add(cardNumbers.clone());
            return;
        }
        for (int i = start; i < cardNumbers.length; i++) {
            swap(cardNumbers, i, start);
            generatePermutations(cardNumbers, start + 1);
            swap(cardNumbers, i, start);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int[] bfs(int startY, int startX, int[] target, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        
        queue.offer(new int[]{startY, startX, 0});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == target[0] && current[1] == target[1]) {
                return current;
            }

            for (int[] dir : directions) {
                int ny = current[0] + dir[0];
                int nx = current[1] + dir[1];

                if (ny >= 0 && ny < 4 && nx >= 0 && nx < 4 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx, current[2] + 1});
                }
            }

            for (int i = 0; i < 4; i++) {
                int[] next = checkRoute(current[0], current[1], directions[i], board);

                if ((next[0] != current[0] || next[1] != current[1]) && !visited[next[0]][next[1]]) {
                    queue.offer(new int[]{next[0], next[1], current[2] + 1});
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        return new int[]{-1, -1, 0};
    }

    private int[] checkRoute(int y, int x, int[] dir, int[][] board) {
        y += dir[0];
        x += dir[1];

        while (y >= 0 && y < 4 && x >= 0 && x < 4) {
            if (board[y][x] != 0) {
                return new int[]{y, x, 0};
            }
            y += dir[0];
            x += dir[1];
        }

        return new int[]{y - dir[0], x - dir[1], 0};
    }
}
