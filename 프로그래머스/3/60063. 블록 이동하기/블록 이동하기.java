import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(int[][] board) {
        return bfs(board);
    }
    
    int bfs(int[][] board) {
        int n = board.length;
        Set<String> visited = new HashSet<>();
        Queue<int[][]> queue = new LinkedList<>();
        
        int[][] start = {{0, 0}, {0, 1}, {0}};
        queue.add(start);
        visited.add(stateToString(start));
        
        while (!queue.isEmpty()) {
            int[][] current = queue.poll();
            int[] pos1 = current[0];
            int[] pos2 = current[1];
            int time = current[2][0];
            
            if ((pos1[0] == n-1 && pos1[1] == n-1) || (pos2[0] == n-1 && pos2[1] == n-1)) {
                return time;
            }
            
            for (int[] dir : dirs) {
                int newPos1Y = pos1[0] + dir[0];
                int newPos1X = pos1[1] + dir[1];
                int newPos2Y = pos2[0] + dir[0];
                int newPos2X = pos2[1] + dir[1];
                
                if (isInBounds(newPos1Y, newPos1X, n) && isInBounds(newPos2Y, newPos2X, n) &&
                    board[newPos1Y][newPos1X] == 0 && board[newPos2Y][newPos2X] == 0) {
                    int[][] nextState = {{newPos1Y, newPos1X}, {newPos2Y, newPos2X}, {time + 1}};
                    if (!visited.contains(stateToString(nextState))) {
                        visited.add(stateToString(nextState));
                        queue.add(nextState);
                    }
                }
            }
            
            if (pos1[0] == pos2[0]) {
                for (int i = -1; i <= 1; i += 2) {
                    int newY = pos1[0] + i;
                    if (isInBounds(newY, pos1[1], n) && isInBounds(newY, pos2[1], n) &&
                        board[newY][pos1[1]] == 0 && board[newY][pos2[1]] == 0) {
                        int[][] nextState1 = {{newY, pos1[1]}, {pos1[0], pos1[1]}, {time + 1}};
                        int[][] nextState2 = {{newY, pos2[1]}, {pos2[0], pos2[1]}, {time + 1}};
                        if (!visited.contains(stateToString(nextState1))) {
                            visited.add(stateToString(nextState1));
                            queue.add(nextState1);
                        }
                        if (!visited.contains(stateToString(nextState2))) {
                            visited.add(stateToString(nextState2));
                            queue.add(nextState2);
                        }
                    }
                }
            } else {
                for (int i = -1; i <= 1; i += 2) {
                    int newX = pos1[1] + i;
                    if (isInBounds(pos1[0], newX, n) && isInBounds(pos2[0], newX, n) &&
                        board[pos1[0]][newX] == 0 && board[pos2[0]][newX] == 0) {
                        int[][] nextState1 = {{pos1[0], newX}, {pos1[0], pos1[1]}, {time + 1}};
                        int[][] nextState2 = {{pos2[0], newX}, {pos2[0], pos2[1]}, {time + 1}};
                        if (!visited.contains(stateToString(nextState1))) {
                            visited.add(stateToString(nextState1));
                            queue.add(nextState1);
                        }
                        if (!visited.contains(stateToString(nextState2))) {
                            visited.add(stateToString(nextState2));
                            queue.add(nextState2);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    String stateToString(int[][] state) {
        return state[0][0] + "," + state[0][1] + "," + state[1][0] + "," + state[1][1];
    }
    
    boolean isInBounds(int y, int x, int n) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
