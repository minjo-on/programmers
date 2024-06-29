import java.util.*;

class TreeNode {
    int x;
    int index;
    TreeNode left;
    TreeNode right;
        
    TreeNode(int x,int index){
        this.x = x;
        this.index = index;
        this.left = null;
        this.right = null;
    }
}
class Solution {
    public void insertNode(TreeNode parent, TreeNode node){
        if(parent.x > node.x){
            if(parent.left == null) parent.left = node;
            else insertNode(parent.left, node);
        }else{
            if(parent.right == null) parent.right = node;
            else insertNode(parent.right, node);
        }
    }
    
    public void pre(TreeNode root, List<Integer> result) {
        if(root != null){
		    result.add(root.index);
		    pre(root.left, result);
		    pre(root.right, result);
	}
    }

    public void post(TreeNode root, List<Integer> result) {
        if(root != null){
		    post(root.left, result);
		    post(root.right, result);
            result.add(root.index);
	}
    }
        
    public int[][] solution(int[][] nodeinfo) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((n1, n2) -> {
            if(n1[1] == n2[1])
                return Integer.compare(n2[0],n1[0]);
            else
                return Integer.compare(n2[1],n1[1]);
        });
        
        for(int i=0;i<nodeinfo.length; i++){
            queue.offer(new int[]{nodeinfo[i][0],nodeinfo[i][1],i+1});
        }
        
        int[] rootNode = queue.poll();
        
        TreeNode root = new TreeNode(rootNode[0],rootNode[2]);
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            insertNode(root, new TreeNode(node[0],node[2]));
        }
        
        List<Integer> preResult = new ArrayList<Integer>();
        pre(root,preResult);
        
        List<Integer> postResult = new ArrayList<Integer>();
        post(root,postResult);
        
        int[] pre = preResult.stream().mapToInt(i->i).toArray();
        int[] post = postResult.stream().mapToInt(i->i).toArray();
        
        int[][] answer = {pre,post};
        
        return answer;
    }
}
