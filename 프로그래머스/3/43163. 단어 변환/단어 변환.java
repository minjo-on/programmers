import java.util.*;

class Word {
    String word;
    int count;

    Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            if (current.word.equals(target)) return current.count;

            for (String next : words) {
                if (!visited.contains(next) && isConvertible(current.word, next)) {
                    visited.add(next);
                    queue.offer(new Word(next, current.count + 1));
                }
            }
        }

        return 0;
    }

    private boolean isConvertible(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}