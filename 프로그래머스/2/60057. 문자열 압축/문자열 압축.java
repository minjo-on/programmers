import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() < 3) return s.length();

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length() / 2; i++) {
            String prev = null;
            int count = 0;
            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < s.length(); j += i) {
                String current = s.substring(j, Math.min(j + i, s.length()));

                if (current.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) builder.append(count);
                    if (prev != null) builder.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            if (count > 1) builder.append(count);
            if (prev != null) builder.append(prev);

            min = Math.min(min, builder.length());
        }

        return min;
    }
}
