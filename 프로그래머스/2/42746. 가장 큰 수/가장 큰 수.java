import java.util.Arrays;
import java.util.stream.Collectors;


class Solution {
    public String solution(int[] numbers) {
		return Arrays.stream(numbers)
			.mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining())
            .replaceAll("^0+", "0");
	}
}