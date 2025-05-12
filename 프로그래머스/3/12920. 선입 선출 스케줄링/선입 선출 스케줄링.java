class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length) return n;
        
        int left = 0;
        int right = 10000 * 50000;
        int time = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long processed = processedJobs(mid, cores);
            
            if (processed >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        long doneBefore = processedJobs(time - 1, cores);
        
        for(int i = 0; i < cores.length; i++) {
            if(time % cores[i] == 0) {
                doneBefore++;
                if(doneBefore == n) return i + 1;
            }
        }
        
        return -1;
    }
    
    private long processedJobs(int t, int[] cores) {
        long count = cores.length;
        for(int core : cores) count += t / core;
        return count;
    }
}