import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
		String[] strings = Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.toArray(String[]::new);

		Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
		String result = String.join("", strings);
		
		if (result.startsWith("0")) return "0";
		
		return result;
	}
}