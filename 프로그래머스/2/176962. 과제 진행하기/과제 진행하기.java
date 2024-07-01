import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {

        String[] answer = new String[plans.length];
        int count = 0;
        Deque<String[]> queue = new LinkedList<>();
        Deque<String[]> remainingTasks = new ArrayDeque<>();

        Arrays.sort(plans, Comparator.comparing(a -> a[1]));

        queue.addAll(Arrays.asList(plans));

        while (!queue.isEmpty()) {
            String[] current = queue.poll();
            String[] next = queue.peek();

            if (next == null) {
                answer[count] = current[0];
                count++;
                while (!remainingTasks.isEmpty()) {
                    answer[count] = remainingTasks.poll()[0];
                    count++;
                }
                break;
            }

            int currentEndTime = calculateEndTime(current);
            int nextStartTime = calculateStartTime(next);

            if (currentEndTime <= nextStartTime) {
                answer[count] = current[0];
                count++;

                int extraTime = nextStartTime - currentEndTime;

                while (!remainingTasks.isEmpty() && extraTime > 0) {
                    String[] remainingTask = remainingTasks.poll();
                    int remainingTaskTime = Integer.parseInt(remainingTask[2]);

                    if (extraTime < remainingTaskTime) {
                        remainingTask[2] = Integer.toString(remainingTaskTime - extraTime);
                        remainingTasks.push(remainingTask);
                        extraTime = 0;
                    } else {
                        extraTime -= remainingTaskTime;
                        answer[count] = remainingTask[0];
                        count++;
                    }
                }
            } else {
                current[2] = Integer.toString(currentEndTime - nextStartTime);
                remainingTasks.push(current);
            }
        }

        return answer;
    }

    private int calculateEndTime(String[] task) {
        String[] time = task[1].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute + Integer.parseInt(task[2]);
    }

    private int calculateStartTime(String[] task) {
        String[] time = task[1].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute;
    }
}
