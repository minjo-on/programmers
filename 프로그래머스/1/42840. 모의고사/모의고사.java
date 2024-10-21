import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
		int[] pattern1 = {1, 2, 3, 4, 5};
		int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] score = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == pattern1[i % pattern1.length]) score[0]++;
			if (answers[i] == pattern2[i % pattern2.length]) score[1]++;
			if (answers[i] == pattern3[i % pattern3.length]) score[2]++;
		}

		int maxScore = IntStream.of(score).max().orElse(0);
		
		List<Integer> answer = IntStream.range(0,3)
				.filter(i -> score[i] == maxScore).map(i -> i + 1)
				.boxed().collect(Collectors.toList());
			
		
		return answer.stream().mapToInt(i -> i).toArray();
	}
}