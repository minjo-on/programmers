import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int totalWaitTime = 0;
        int jobIndex = 0;
        int second = 0;

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        while (!priorityQueue.isEmpty() || jobIndex < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= second) {
                priorityQueue.offer(jobs[jobIndex++]);
            }

            if (priorityQueue.isEmpty()) {
                second = jobs[jobIndex][0];
            } else {
                int[] currentJob = priorityQueue.poll();
                second += currentJob[1];
                totalWaitTime += second - currentJob[0];
            }
        }

        return totalWaitTime / jobs.length;
    }
}