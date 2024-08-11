import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int bIndex = 0;

        Integer[] a = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());

        for (int aNum : a){
            if (aNum < b[bIndex]){
                answer++;
                bIndex++;
            }
        }

        return answer;
    }
}