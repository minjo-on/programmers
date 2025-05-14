import java.util.*;

class Solution {
    public class Node {
        int num; 
        Queue<Node> children;
        List<Integer> rawChildren;

        public Node(int n) {
            this.num = n;
            children = new ArrayDeque<>();
            rawChildren = new ArrayList<>();
        }

        public void initializeQueue() {
            Collections.sort(rawChildren);
            for (Integer childIdx : rawChildren) {
                children.add(nodes[childIdx]);
            }
        }
    }

    int N;
    Node[] nodes;
    Node root;
    List<Integer> leaves = new ArrayList<>();
    List<Integer> dropSequence = new ArrayList<>();
    Map<Integer, Integer> dropCount = new HashMap<>();
    Map<Integer, Integer> targetMap = new HashMap<>();

    public int[] solution(int[][] edges, int[] target) {
        initializeTree(edges, target);
        if (!simulateDropping()) return new int[]{-1};
        return assignValues();
    }

    private void initializeTree(int[][] edges, int[] target) {
        N = target.length;
        nodes = new Node[N];
        for (int i = 0; i < N; i++) nodes[i] = new Node(i);
        root = nodes[0];

        for (int[] edge : edges) {
            int parent = edge[0] - 1;
            int child = edge[1] - 1;
            nodes[parent].rawChildren.add(child);
        }

        for (Node node : nodes) node.initializeQueue();

        for (int i = 0; i < N; i++) {
            if (nodes[i].children.isEmpty()) {
                leaves.add(i);
                dropCount.put(i, 0);
                targetMap.put(i, target[i]);
            }
        }
    }

    private boolean simulateDropping() {
        while (true) {
            Node current = root;
            while (!current.children.isEmpty()) {
                Node next = current.children.poll();
                current.children.add(next);
                current = next;
            }

            dropSequence.add(current.num);
            dropCount.put(current.num, dropCount.get(current.num) + 1);

            boolean needMoreDrops = false;

            for (Integer leaf : leaves) {
                int target = targetMap.get(leaf);
                int count = dropCount.get(leaf);

                if (target == 0) {
                    if (count != 0) return false;
                } else {
                    if (count == 0 || target / count > 3 || (target / count == 3 && target % count != 0)) {
                        needMoreDrops = true;
                        break;
                    } else if (target / count == 0) {
                        return false;
                    }
                }
            }

            if (!needMoreDrops) break;
        }
        return true;
    }

    private int[] assignValues() {
        int[] result = new int[dropSequence.size()];
        for (int i = 0; i < result.length; i++) {
            int leaf = dropSequence.get(i);
            int count = dropCount.get(leaf);
            int total = targetMap.get(leaf);
            int value;
            
            if (total - 1 <= (count - 1) * 3) value = 1;
            else if (total - 2 <= (count - 1) * 3) value = 2;
            else value = 3;

            result[i] = value;
            dropCount.put(leaf, count - 1);
            targetMap.put(leaf, total - value);
        }
        return result;
    }
}
