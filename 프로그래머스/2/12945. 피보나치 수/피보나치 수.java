import java.util.*;

class Solution {
    public int solution(int n) {
        long[] arr = new long[n + 1];
        
        Arrays.fill(arr, -1);
        
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        
        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        
        return (int) arr[n];
    }
}