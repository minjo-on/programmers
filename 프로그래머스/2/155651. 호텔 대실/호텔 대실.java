import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, Comparator.comparing(a -> a[0]));
        
        PriorityQueue<String> pq = new PriorityQueue<>();
    
        for (String[] time : book_time) {
            String start = time[0];
            String end = time[1];

            while (!pq.isEmpty()) {
                if (pq.peek().compareTo(start) <= 0) {
                    pq.poll();
                } else {
                    break;
                }
            }

            pq.offer(addTenMinutes(end));
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    private String addTenMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        minute += 10;
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }

        return String.format("%02d:%02d", hour, minute);
    }
}