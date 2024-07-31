class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for (int i = 0; i < cookie.length - 1; i++){
            int leftSum = cookie[i];
            int rightSum = cookie[i + 1];
            int left = i;
            int right = i + 1;
            
            while (true){
                if (leftSum == rightSum){
                    answer = Math.max(answer, leftSum);
                }
                
                if (left > 0 && leftSum <= rightSum){
                    leftSum += cookie[--left];
                } else if (right < cookie.length - 1 && rightSum <= leftSum) {
                    rightSum += cookie[++right];
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}