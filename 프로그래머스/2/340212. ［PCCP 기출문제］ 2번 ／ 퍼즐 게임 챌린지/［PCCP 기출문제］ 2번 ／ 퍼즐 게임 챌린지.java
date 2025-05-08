class Solution {
    private long getTotalTime(int[] diffs, int[] times, int levels) {
        long total = times[0];
        for(int i = 1; i < diffs.length; i++) {
            if(diffs[i] <= levels) {
                total += times[i];
            } else {
                int retry = diffs[i] - levels;
                total += retry * (times[i] + times[i - 1]) + times[i];
            }
        }
        return total;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            long total = getTotalTime(diffs, times, mid);
            
            if(total <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}