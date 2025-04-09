import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) count++;
        }

        return count;
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                case ')': case '}': case ']':
                    if (stack.isEmpty() || stack.pop() != c) return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
