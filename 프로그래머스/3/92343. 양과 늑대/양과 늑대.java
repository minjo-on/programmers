import java.util.*;

class Solution {
     private int answer = 0;

    public int solution(int[] info, int[][] edges) {
        List<Integer>[] tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0, 0, 0, info, tree, nextNodes);
        return answer;
    }

    private void dfs(int node, int sheep, int wolves, int[] info, List<Integer>[] tree, List<Integer> nextNodes) {
        if (info[node] == 0) {
            sheep++;
        } else {
            wolves++;
        }

        if (wolves >= sheep) {
            return;
        }

        answer = Math.max(answer, sheep);

        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(node));
        newNextNodes.addAll(tree[node]);

        for (int nextNode : newNextNodes) {
            dfs(nextNode, sheep, wolves, info, tree, newNextNodes);
        }
    }
}