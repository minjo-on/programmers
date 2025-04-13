import java.util.*;

class Solution {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        Set<String> visitedEdges = new HashSet<>();
        Set<String> visitedNodes = new HashSet<>();
        
        int x = 0;
        int y = 0;
        
        visitedNodes.add("0,0");
        
        int rooms = 0;
        
        for(int dir : arrows) {
            for(int i = 0; i < 2; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                String currentNode = x + "," + y;
                String nextNode = nx + "," + ny;
                
                String edge = currentNode + "-" + nextNode;
                String reverseEdge = nextNode + "-" + currentNode;
                
                if(visitedNodes.contains(nextNode) && !visitedEdges.contains(edge)) rooms++;
                
                visitedNodes.add(nextNode);
                visitedEdges.add(edge);
                visitedEdges.add(reverseEdge);
                
                x = nx;
                y = ny;
            }
        }
        
        return rooms;
    }
}
