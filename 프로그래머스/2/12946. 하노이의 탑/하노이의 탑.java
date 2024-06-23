import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>();
        hanoi(n,1,3,2,list);
        return list.toArray(new int[list.size()][]);
    }
    
    private void hanoi(int n, int from, int to, int aux,List<int[]> moves){
        if(n == 1){
            moves.add(new int[] {from,to});
            return;
        }
        hanoi(n-1,from,aux,to,moves);
        moves.add(new int[] {from,to});
        hanoi(n-1,aux,to,from,moves);
    }
}