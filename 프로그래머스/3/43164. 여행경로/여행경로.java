import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path, 0);
        
        return result.toArray(new String[0]);
    }

    void dfs(String current, String[][] ticket, List<String> path, int count){
        if (count == ticket.length) {
            if (result.isEmpty() || String.join("", path).compareTo(String.join("", result)) < 0) {
                result = new ArrayList<>(path);
            }
            return;
        }

        for (int i = 0; i < ticket.length; i++) {
            if (!visited[i] && ticket[i][0].equals(current)) {
                visited[i] = true;
                path.add(ticket[i][1]);
                dfs(ticket[i][1], ticket, path, count + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}