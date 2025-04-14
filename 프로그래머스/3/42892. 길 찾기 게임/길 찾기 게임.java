import java.util.*;

class Solution {
    class TreeNode {
        int x, index;
        TreeNode left, right;
        TreeNode(int x, int index) {
            this.x = x;
            this.index = index;
        }
    }

    private void insert(TreeNode parent, TreeNode child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.index);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    private void postorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.index);
    }

    public int[][] solution(int[][] nodeinfo) {
        List<int[]> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1});
        }

        nodes.sort((a, b) -> b[1] - a[1]);

        TreeNode root = new TreeNode(nodes.get(0)[0], nodes.get(0)[2]);
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, new TreeNode(nodes.get(i)[0], nodes.get(i)[2]));
        }

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preorder(root, pre);
        postorder(root, post);

        return new int[][] {
            pre.stream().mapToInt(i -> i).toArray(),
            post.stream().mapToInt(i -> i).toArray()
        };
    }
}
