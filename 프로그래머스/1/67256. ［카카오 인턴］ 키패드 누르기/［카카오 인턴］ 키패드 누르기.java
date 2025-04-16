import java.util.*;

class Solution {
    Map<Integer, int[]> pos = Map.of(
        1, new int[]{0, 0}, 2, new int[]{0, 1}, 3, new int[]{0, 2},
        4, new int[]{1, 0}, 5, new int[]{1, 1}, 6, new int[]{1, 2},
        7, new int[]{2, 0}, 8, new int[]{2, 1}, 9, new int[]{2, 2},
        0, new int[]{3, 1}
    );

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        String handInitial = hand.substring(0, 1).toUpperCase();

        for (int n : numbers) {
            if (n % 3 == 1) {
                sb.append("L");
                left = pos.get(n);
            } else if (n != 0 && n % 3 == 0) {
                sb.append("R");
                right = pos.get(n);
            } else {
                int leftDist = distance(left, n);
                int rightDist = distance(right, n);

                if (leftDist < rightDist) {
                    sb.append("L");
                    left = pos.get(n);
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    right = pos.get(n);
                } else {
                    if (handInitial.equals("L")) {
                        sb.append("L");
                        left = pos.get(n);
                    } else {
                        sb.append("R");
                        right = pos.get(n);
                    }
                }
            }
        }

        return sb.toString();
    }

    private int distance(int[] from, int to) {
        int[] toPos = pos.get(to);
        return Math.abs(from[0] - toPos[0]) + Math.abs(from[1] - toPos[1]);
    }
}
