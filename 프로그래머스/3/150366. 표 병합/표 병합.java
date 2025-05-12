import java.util.*;

class Solution {
    int[] parent = new int[2500];
    String[] values = new String[2500];

    public String[] solution(String[] commands) {
        for (int i = 0; i < 2500; i++) parent[i] = i;

        List<String> answer = new ArrayList<>();

        for (String cmd : commands) {
            String[] c = cmd.split(" ");
            String type = c[0];

            if (type.equals("UPDATE")) {
                if (c.length == 4) {
                    int r = Integer.parseInt(c[1]) - 1;
                    int col = Integer.parseInt(c[2]) - 1;
                    int idx = find(r * 50 + col);
                    values[idx] = c[3];
                } else {
                    for (int i = 0; i < 2500; i++) {
                        int root = find(i);
                        if (values[root] != null && values[root].equals(c[1])) {
                            values[root] = c[2];
                        }
                    }
                }
            }

            else if (type.equals("MERGE")) {
                int r1 = Integer.parseInt(c[1]) - 1, c1 = Integer.parseInt(c[2]) - 1;
                int r2 = Integer.parseInt(c[3]) - 1, c2 = Integer.parseInt(c[4]) - 1;
                int idx1 = r1 * 50 + c1;
                int idx2 = r2 * 50 + c2;
                int root1 = find(idx1);
                int root2 = find(idx2);

                if (root1 != root2) {
                    // 병합된 값 결정: root1 우선, 없으면 root2
                    String val = values[root1] != null ? values[root1] : values[root2];
                    parent[root2] = root1;
                    values[root1] = val;
                    values[root2] = null;
                }
            }

            else if (type.equals("UNMERGE")) {
                int r = Integer.parseInt(c[1]) - 1;
                int col = Integer.parseInt(c[2]) - 1;
                int idx = r * 50 + col;
                int root = find(idx);
                String val = values[root];

                List<Integer> group = new ArrayList<>();
                for (int i = 0; i < 2500; i++) {
                    if (find(i) == root) group.add(i);
                }
                for (int i : group) {
                    parent[i] = i;
                    values[i] = null;
                }
                values[idx] = val;
            }

            else if (type.equals("PRINT")) {
                int r = Integer.parseInt(c[1]) - 1;
                int col = Integer.parseInt(c[2]) - 1;
                int idx = find(r * 50 + col);
                answer.add(values[idx] == null ? "EMPTY" : values[idx]);
            }
        }

        return answer.toArray(new String[0]);
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
