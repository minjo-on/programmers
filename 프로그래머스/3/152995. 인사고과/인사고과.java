import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n1 = scores[0][0];
        int n2 = scores[0][1];
        int rank = 0;

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        int max = scores[0][1];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][1] < max){
                if (scores[i][0] == n1 && scores[i][1] == n2) return -1;
                
                scores[i][0] = -1;
                scores[i][1] = -1;
            }else {
                max = scores[i][1];
            }
        }

        Arrays.sort(scores, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        for (int[] score : scores){
            if (score[0] + score[1] > n1 + n2) rank += 1;
            else break;
        }

        return rank + 1;
    }
}
