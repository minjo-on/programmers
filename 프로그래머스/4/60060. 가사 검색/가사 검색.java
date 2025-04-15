import java.util.*;

class Trie {
    Map<Character, Trie> children = new HashMap<>();
    int count = 0;
    
    public void insert(String word) {
        Trie node = this;
        node.count++;
        for(char ch : word.toCharArray()){
            node = node.children.computeIfAbsent(ch, c -> new Trie());
            node.count++;
        }
    }
    
    public int search(String query) {
        Trie node = this;
        for(char c : query.toCharArray()) {
            if(c == '?') break;
            if(!node.children.containsKey(c)) return 0;
            node = node.children.get(c);
        }
        return node.count;
    }
}
class Solution {
    Map<Integer, Trie> forwardMap = new HashMap<>();
    Map<Integer, Trie> reverseMap = new HashMap<>();
    
    public int[] solution(String[] words, String[] queries) {
        for(String word : words) {
            int len = word.length();
            forwardMap.putIfAbsent(len, new Trie());
            forwardMap.get(len).insert(word);
            
            reverseMap.putIfAbsent(len, new Trie());
            reverseMap.get(len).insert(new StringBuilder(word).reverse().toString());
        }
        
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            
            if(query.charAt(0) != '?') {
                Trie trie = forwardMap.get(len);
                answer[i] = trie == null ? 0 : trie.search(query);
            } else {
                Trie trie = reverseMap.get(len);
                String reversed = new StringBuilder(query).reverse().toString();
                answer[i] = trie == null ? 0 : trie.search(reversed);
            }
        }
        
        return answer;
    }
}