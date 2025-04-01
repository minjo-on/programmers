class Solution {
    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;
        
        while(!s.equals("1")){
            int length = s.length();
            s = s.replace("0", "");
            removed += length - s.length();
            
            s = Integer.toBinaryString(s.length());
            loop++;
        }
        
        return new int[]{loop, removed};
    }
}