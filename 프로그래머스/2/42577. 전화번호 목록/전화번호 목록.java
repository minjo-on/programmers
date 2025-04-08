import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = Arrays.stream(phone_book)
                .collect(Collectors.toMap(phone -> phone, phone -> 1));

        return Arrays.stream(phone_book)
                .noneMatch(phone ->
                        IntStream.range(1, phone.length())
                                .anyMatch(i -> map.containsKey(phone.substring(0,i)))
                );
    }
}