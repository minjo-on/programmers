import java.util.*;

public class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int answer = dist.length + 1;
        int len = weak.length;
        int[] arr = new int[len * 2];

        for (int i = 0; i < len; i++) {
            arr[i] = weak[i];
            arr[i + len] = weak[i] + n;
        }

        List<int[]> perms = getPermutations(dist);

        for (int start = 0; start < len; start++) {
            for (int[] perm : perms) {
                int count = 0;
                int position = arr[start] + perm[count];

                for (int j = start + 1; j < start + len; j++) {
                    if (position < arr[j]) {
                        count++;
                        if (count >= perm.length) break;
                        position = arr[j] + perm[count];
                    }
                }

                if (count < perm.length) {
                    answer = Math.min(answer, count + 1);
                }
            }
        }

        return answer > dist.length ? -1 : answer;
    }

    private List<int[]> getPermutations(int[] dist) {
        List<int[]> result = new ArrayList<>();
        permute(dist, 0, result);
        return result;
    }

    private void permute(int[] arr, int start, List<int[]> result) {
        if (start == arr.length) {
            result.add(arr.clone());
        } else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, i, start);
                permute(arr, start + 1, result);
                swap(arr, i, start);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
