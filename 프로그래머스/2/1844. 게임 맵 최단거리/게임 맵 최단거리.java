import java.util.*;

class Solution {
     public int solution(int[][] maps) {
        int h = maps.length;
        int w = maps[0].length;

        int[] dy = new int[]{1,-1,0,0};
        int[] dx = new int[]{0,0,1,-1};

        boolean[][] visited = new boolean[h][w];

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0,1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.y == h - 1 && current.x == w - 1){
                return current.count;
            }

            for(int i = 0; i < 4; i++){
                int newY = current.y + dy[i];
                int newX = current.x + dx[i];

                if(newY >=0 && newY < h && newX >= 0 && newX < w && !visited[newY][newX] && maps[newY][newX] == 1){
                    visited[newY][newX] = true;
                    queue.add(new Node(newY, newX,current.count+1));
                }
            }
        }
        return -1;
    }

    class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
