class Solution {
    public int solution(int n) {  
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }
        
        return catalan[n];      
    }
}