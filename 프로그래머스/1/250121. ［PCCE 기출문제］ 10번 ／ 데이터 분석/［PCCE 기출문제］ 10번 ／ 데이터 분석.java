import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] index = new String[]{"code","date","maximum","remain"};
        int e = Arrays.asList(index).indexOf(ext);
        int s = Arrays.asList(index).indexOf(sort_by);

        int[][] answer = Arrays.stream(data)
                .filter(arr -> arr[e] < val_ext)
                .sorted(Comparator.comparingInt(arr -> arr[s]))
                .toArray(int[][]::new);

        return answer;
    }
}