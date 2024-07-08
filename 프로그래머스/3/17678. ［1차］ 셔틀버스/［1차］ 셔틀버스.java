import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String time : timetable) {
            pq.add(convertTime(time));
        }

        int busTime = 540;
        int lastTime = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            while (!pq.isEmpty() && pq.peek() <= busTime && cnt < m) {
                lastTime = pq.poll();
                cnt++;
            }

            if (i == n - 1) {
                if (cnt < m) {
                    lastTime = busTime;
                } else {
                    lastTime = lastTime - 1;
                }
            }

            busTime += t;
        }

        return String.format("%02d:%02d", lastTime / 60, lastTime % 60);
    }

    private int convertTime(String time) {
        String[] arr = time.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        return h * 60 + m;
    }
}
