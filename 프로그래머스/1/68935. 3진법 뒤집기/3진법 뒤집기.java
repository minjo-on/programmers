class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toString(n, 3);
        String rs = new StringBuilder(s).reverse().toString();
        
        return Integer.valueOf(rs, 3);
    }
}