import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted(Comparator
                        .comparing((String a) -> a.charAt(n))
                        .thenComparing(a -> a))
                .toArray(String[]::new);
    }
}
