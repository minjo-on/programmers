import java.util.*;

public class Solution {
    public int solution(int[] a) {
        if (a.length <= 2) return a.length;

        int left = a[0];
        int right = a[a.length - 1];
        int result = 1;

        for (int i = 1; i < a.length; i++) {
            left = Math.min(left, a[i]);
            right = Math.min(right, a[a.length - 1 - i]);
            if (a[i] == left) result++;
            if (a[a.length - 1 - i] == right) result++;
        }

        return result;
    }
}
