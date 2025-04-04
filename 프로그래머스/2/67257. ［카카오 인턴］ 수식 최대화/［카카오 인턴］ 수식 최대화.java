import java.util.*;
import java.util.regex.*;

class Solution {
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        Matcher m = Pattern.compile("\\d+|[+\\-*]").matcher(expression);
        while (m.find()) {
            String token = m.group();
            if (token.matches("\\d+")) {
                numbers.add(Long.parseLong(token));
            } else {
                operators.add(token);
            }
        }

        Set<String> operatorSet = new HashSet<>(operators);
        List<List<String>> permutations = getPermutations(new ArrayList<>(operatorSet));

        long max = 0;
        for (List<String> opPriority : permutations) {
            long result = calculate(new ArrayList<>(numbers), new ArrayList<>(operators), opPriority);
            max = Math.max(max, Math.abs(result));
        }

        return max;
    }

    private long calculate(List<Long> nums, List<String> ops, List<String> priority) {
        for (String op : priority) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i).equals(op)) {
                    long a = nums.get(i);
                    long b = nums.get(i + 1);
                    long result = applyOp(a, b, op);

                    nums.remove(i + 1);
                    nums.set(i, result);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }

    private long applyOp(long a, long b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> 0;
        };
    }

    private List<List<String>> getPermutations(List<String> ops) {
        List<List<String>> result = new ArrayList<>();
        permute(ops, 0, result);
        return result;
    }

    private void permute(List<String> arr, int index, List<List<String>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, i, index);
            permute(arr, index + 1, result);
            Collections.swap(arr, i, index);
        }
    }
}
