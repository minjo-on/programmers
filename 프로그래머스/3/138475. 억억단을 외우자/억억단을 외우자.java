import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisorCount = new int[e + 1];
        int[] mostFrequent = new int[e + 1];

        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divisorCount[j]++;
            }
        }

        int maxIndex = e;
        for (int i = e; i >= 1; i--) {
            if (divisorCount[i] >= divisorCount[maxIndex]) {
                maxIndex = i;
            }
            mostFrequent[i] = maxIndex;
        }

        for (int i = 0; i < starts.length; i++) {
            answer[i] = mostFrequent[starts[i]];
        }

        return answer;
    }
}
