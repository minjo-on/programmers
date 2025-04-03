class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int h = 3; h <= Math.sqrt(total); h++){
            if (total % h == 0){
                int w = total / h;
                
                if(((h - 2) * (w - 2)) == yellow){
                    return new int[]{w, h};
                }
            }
        }
        
        return new int[]{};
    }
}