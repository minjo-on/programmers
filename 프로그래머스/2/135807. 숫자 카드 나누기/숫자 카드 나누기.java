class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int result = 0;
        if (isValid(gcdA, arrayB)) result = gcdA;
        if (isValid(gcdB, arrayA)) result = Math.max(result, gcdB);
        return result;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private boolean isValid(int candidate, int[] array) {
        for (int num : array) {
            if (num % candidate == 0) return false;
        }
        return true;
    }
}