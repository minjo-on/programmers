import java.util.Arrays;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        int n = land.length;
        long[] heights = new long[n * n];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                heights[index++] = land[i][j];
            }
        }
        
        Arrays.sort(heights);
        
        long add = 0; 
        for (long height : heights) {
            add += (height - heights[0]) * Q;
        }
        
        long min = add;
        long remove = 0;
        
        for (int i = 1; i < heights.length; i++) {
            long diff = heights[i] - heights[i - 1];
            remove += (long) i * diff * P;
            add -= (long) (heights.length - i) * diff * Q;
            min = Math.min(min, remove + add);
        }
        
        return min;
    }
}
