class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        long targetValue = Long.parseLong(p); 

        for (int i = 0; i <= t.length() - length; i++) {
            long currentValue = Long.parseLong(t.substring(i, i + length));
            if (currentValue <= targetValue) {
                answer++;
            }
        }
        
        return answer;
    }
}
