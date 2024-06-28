import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int e = filter(ext);
        int s = filter(sort_by);

        int[][] answer = Arrays.stream(data)
                .filter(arr -> arr[e] < val_ext)
                .sorted(Comparator.comparing(arr -> arr[s]))
                .toArray(int[][]::new);

        return answer;
    }

    private int filter(String s){
        int n = 0;
        switch (s){
            case "code" : n = 0; break;
            case "date" : n = 1; break;
            case "maximum" : n = 2; break;
            case "remain" : n = 3; break;
        }
        return n;
    }
}