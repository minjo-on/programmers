import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n < 2) return 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : a) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) * 2 <= maxLength) continue;

            int length = 0;
            for (int i = 0; i < n - 1; i++) {
                if ((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]) {
                    length += 2;
                    i++;
                }
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}