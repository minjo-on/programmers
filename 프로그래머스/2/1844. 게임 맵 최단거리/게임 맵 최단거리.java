import java.util.*;

class Solution {
     public int solution(int[][] maps) {
        int h = maps.length;
        int w = maps[0].length;

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0,1));
        maps[0][0] = 0;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.y == h - 1 && current.x == w - 1){
                return current.count;
            }

            for(int[] dir : dirs){
                int newY = current.y + dir[0];
                int newX = current.x + dir[1];

                if(newY >=0 && newY < h && newX >= 0 && newX < w &&  maps[newY][newX] == 1){
                    maps[newY][newX] = 0;
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
