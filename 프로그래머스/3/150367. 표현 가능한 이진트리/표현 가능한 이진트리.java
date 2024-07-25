class Solution {
    boolean flag;

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int k = 0; k < answer.length; k++) {
            String binaryNum = Long.toBinaryString(numbers[k]);

            int treeLength = 0;
            int h = 1;
            while (treeLength < binaryNum.length()) treeLength = (int) Math.pow(2, h++) - 1;
            boolean[] tree = new boolean[treeLength];

            int notBinary = tree.length - binaryNum.length();
            for (int i = 0; i < binaryNum.length(); i++) tree[notBinary++] = binaryNum.charAt(i) == '1';

            flag = true;
            dfs(0, tree.length - 1, false, tree);
            answer[k] = flag? 1 : 0;
        }

        return answer;
    }

    void dfs(int left, int right, boolean parent, boolean[] tree) {
        if (!flag) return;

        int mid = (left + right) / 2;

        if(parent && tree[mid]) {
            flag = false;
            return;
        }

        if(left != right) {
            dfs(left, mid - 1, !tree[mid], tree);
            dfs(mid + 1, right, !tree[mid], tree);
        }
    }
}