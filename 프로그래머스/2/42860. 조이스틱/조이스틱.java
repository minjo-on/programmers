class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int minMove = length- 1;

        for (int i = 0; i < length; i++) {
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            int move = i + length - nextIndex + Math.min(i, length - nextIndex);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;
        return answer;
    }
}