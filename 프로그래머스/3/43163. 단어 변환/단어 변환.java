import java.util.*;

class Word{
        String word;
        int count;

        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin,0));
        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()){
            Word current = queue.poll();
            if (current.word.equals(target)) {
                return current.count;
            }

            
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                int c = 0;
                for(int j = 0; j < current.word.length(); j++){
                    if(current.word.charAt(j) != words[i].charAt(j)){
                        c++;
                    }
                }
                if(c == 1){
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.count + 1));
                }
            }
        }
        return 0;
    }
}