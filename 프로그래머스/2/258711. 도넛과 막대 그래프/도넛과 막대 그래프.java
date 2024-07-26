import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int length = 0;

        for (int[] edge : edges) {
            length = Math.max(length, Math.max(edge[0], edge[1]));
        }

        int N = length + 1;

        int[] outDegrees = new int[N];
        int[] inDegrees = new int[N];

        for (int[] edge : edges) {
            outDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        }

        int[] answer = new int[4];
        int notZeroOut = -1;
        int zeroIn = 0;

        for (int i = 0; i < N; i++) {
            if (outDegrees[i] > 1) {
                if (inDegrees[i] == 0) {
                    notZeroOut = i;
                } else {
                    answer[3]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDegrees[i] > 0 && outDegrees[i] == 0) {
                zeroIn++;
            }
        }

        if (notZeroOut != -1) {
            answer[0] = notZeroOut;
            answer[1] = outDegrees[notZeroOut] - zeroIn - answer[3];
        }

        answer[2] = zeroIn;
        return answer;
    }
}