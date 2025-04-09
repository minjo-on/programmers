import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int i = stack.pop();
            answer[i] = n - i - 1;
        }
        
        return answer;
    }
}