class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long answer = (long) (10e9 * 2 * 10e5 * 2);
        long right = (long) (10e9 * 2 * 10e5 * 2);
        
        while (left <= right) {
            long mid = (left + right) / 2;

            long totalGold = 0;
            long totalSilver = 0;
            long totalWeight = 0;

            for (int i = 0; i < g.length; i++) {
                long maxTrips = mid / (2L * t[i]);
                
                if(mid % (2L * t[i]) >= t[i]) maxTrips++;
                long maxWeight = maxTrips * w[i];

                totalGold += Math.min(g[i], maxWeight);
                totalSilver += Math.min(s[i], maxWeight);
                totalWeight += Math.min(g[i] + s[i], maxWeight);
            }
            
            if (totalGold >= a && totalSilver >= b && totalWeight >= a + b) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}