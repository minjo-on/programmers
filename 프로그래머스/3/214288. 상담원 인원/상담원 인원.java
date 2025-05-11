import java.util.*;

class Solution {
    int minWaitTime = Integer.MAX_VALUE;
    public int solution(int k, int n, int[][] reqs) {
        List<List<int[]>> byType = new ArrayList<>();
        for(int i = 0; i <= k; i++) {
            byType.add(new ArrayList<>());
        }
        
        for(int[] req : reqs) {
            byType.get(req[2]).add(new int[]{req[0], req[1]});
        }
        
        dfs(k, 1, new int[k + 1], n, byType);
        return minWaitTime;
    }
    
    private void dfs(int k, int idx, int[] mentors, int left, List<List<int[]>> byType) {
        if(idx == k) {
            if(left < 1) return;
            mentors[idx] = left;
            simulate(mentors, byType);
            return;
        }
        
        for(int i = 1; i <= left - (k - idx); i++) {
            mentors[idx] = i;
            dfs(k, idx + 1, mentors.clone(), left - i, byType);
        }
    }
    
    private void simulate(int[] mentors, List<List<int[]>> byType) {
        int totalWait = 0;
        
        for(int type = 1; type < mentors.length; type++) {
            int mentorCount = mentors[type];
            List<int[]> requests = byType.get(type);
            requests.sort(Comparator.comparingInt(r -> r[0]));
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            for(int[] req : requests) {
                int start = req[0];
                int duration = req[1];
                
                if(pq.size() < mentorCount) {
                    pq.offer(start + duration);
                } else {
                    int availableTime = pq.poll();
                    totalWait += Math.max(0, availableTime - start);
                    pq.offer(Math.max(start, availableTime) + duration);
                }
            }
        }
        
        minWaitTime = Math.min(totalWait, minWaitTime);
    }
}