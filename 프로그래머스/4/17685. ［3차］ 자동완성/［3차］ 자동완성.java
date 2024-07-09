import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        int prevCount = 0;

        for(int i = 0; i < words.length - 1; i++){
            String current = words[i];
            String next = words[i + 1];
            int count = getSameCount(current, next, Math.min(current.length(), next.length()));
            if(count < current.length()){
                answer += Math.max(count + 1, prevCount + 1);
            }else{
                answer += Math.max(count, prevCount + 1);
            }
            prevCount = count;
            if (i == words.length - 2){
                if(count == 0){
                    answer += 1;
                }else{
                    answer += count + 1;
                }
            }
        }
        return answer;
    }

    int getSameCount(String pre, String next, int len) {
        int count = 0;
        for(int j = 0; j < len; j++) {
            if(pre.charAt(j) != next.charAt(j)) {
                return count;
            }
            count++;
        }
        return count;
    }
}
