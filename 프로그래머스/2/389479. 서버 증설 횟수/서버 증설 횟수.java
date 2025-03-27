import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentServer = 0;
        int currentTime = 0;
        
        Map<Integer, Integer> histories = new HashMap<>();
        
        for(int userCount : players) {
            currentServer -= histories.getOrDefault(currentTime - k, 0);
            
            int useServer = userCount / m;
            
            if(useServer > currentServer) {
                int addServer = useServer - currentServer;
                histories.put(currentTime, addServer);
                answer += addServer;
                currentServer += addServer;
            }
            
            currentTime++;
        }
        
        return answer;
    }
}