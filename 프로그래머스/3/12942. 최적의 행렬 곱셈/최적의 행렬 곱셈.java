class Solution {
    public int solution(int[][] matrix_sizes) {
        int size = matrix_sizes.length;
        
        int[] p = new int[size + 1];
        p[0] = matrix_sizes[0][0];
        for (int i = 0; i < size; i++) p[i + 1] = matrix_sizes[i][1];

        int[][] dp = new int[size + 1][size + 1];
        for (int i = 0; i < dp.length; i++) dp[i][i] = 0;

        for (int length = 2; length <= size; length++){
            
            for (int start = 1; start <= size - length + 1; start++){
                int end = start + length - 1;
                dp[start][end] = Integer.MAX_VALUE;
                
                for (int middle = start; middle <= end - 1; middle++){
                    int result = dp[start][middle] + dp[middle + 1][end] + p[start - 1] * p[middle] * p[end];
                    dp[start][end] = Math.min(result, dp[start][end]);
                }
            }
        }
        
        return dp[1][size];
    }
}