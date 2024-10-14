import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        return set.stream().noneMatch(s ->
                IntStream.range(1, s.length())
                        .anyMatch(i -> set.contains(s.substring(0, i)))
        );
    }
}