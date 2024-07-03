import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;

        List<List<Integer>> tree = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        boolean[] visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        for (int[] ed : edge){
            tree.get(ed[0]).add(ed[1]);
            tree.get(ed[1]).add(ed[0]);
        }

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            if(node[1] > max){
                max = node[1];
                answer = 1;
            }else if (node[1] == max){
                answer++;
            }

            for (int neighbor : tree.get(node[0])){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node[1] + 1});
                }
            }
        }

        return answer;
    }
}