import java.util.*;

class Solution {
    private static char[] CHARS = {'A', 'E', 'I', 'O', 'U'};
    
    private void generate(String word, List<String> lists){
        if(word.length() > 5) return;
        
        lists.add(word);
        for(int i = 0; i < CHARS.length; i++){
            generate(word + CHARS[i], lists);
        }
    }
    
    public int solution(String word) {
        List<String> lists = new ArrayList<>();
        generate("", lists);
        return lists.indexOf(word);
    }
}