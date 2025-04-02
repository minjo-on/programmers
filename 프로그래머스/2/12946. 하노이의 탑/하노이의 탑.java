import java.util.*;

class Solution {
    public static List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(n, 1, 3);
        return moves.toArray(new int[moves.size()][]);
    }
    
    private void hanoi(int n, int from, int to){
        if(n == 1){
            moves.add(new int[] {from, to});
            return;
        }
        
        int aux = 6 - from - to;
        
        hanoi(n - 1, from, aux);
        moves.add(new int[] {from, to});
        hanoi(n - 1, aux, to);
    }
}