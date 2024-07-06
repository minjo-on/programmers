import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (String s : operations){
            String[] operation = s.split(" ");
            char op = operation[0].charAt(0);
            int value = Integer.parseInt(operation[1]);

            if(op == 'D'){
                if(priorityQueue.isEmpty()) continue;
                if(value == -1){
                    int min = Collections.min(priorityQueue);
                    priorityQueue.remove(min);
                }else {
                    priorityQueue.poll();
                }
            }else{
                priorityQueue.add(value);
            }

        }
        if (priorityQueue.isEmpty()) return new int[]{0, 0};
        return new int[]{priorityQueue.peek(), Collections.min(priorityQueue)};
    }
}