import java.util.*;

class Solution {
    public long solution(long n) {
        int[] digits = String.valueOf(n)
                             .chars()
                             .map(c -> c - '0')
                             .toArray();

        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }

        return Long.parseLong(sb.toString());
    }
}
