import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        String prev = words[0];
        used.add(prev);

        for (int i = 1; i < words.length; i++) {
            String curr = words[i];

            boolean isDuplicate = used.contains(curr);
            boolean isInvalidChain = prev.charAt(prev.length() - 1) != curr.charAt(0);

            if (isDuplicate || isInvalidChain) {
                int person = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{person, turn};
            }

            used.add(curr);
            prev = curr;
        }

        return new int[]{0, 0};
    }
}
