import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;
        Stack<Character> stack = new Stack<>();
        
        for(char c : number.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        for(int i = 0; i < len; i++) {
            answer.append(stack.get(i));
        }
        
        return answer.toString();
    }
}