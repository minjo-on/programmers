import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> resultSet = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];

        dfs(user_id, banned_id, 0, new HashSet<>(), visited, resultSet);

        return resultSet.size();
    }

    private void dfs(String[] user_id, String[] banned_id, int index, Set<String> currentSet, boolean[] visited, Set<Set<String>> resultSet) {
        if (index == banned_id.length) {
            resultSet.add(new HashSet<>(currentSet));
            return;
        }

        String pattern = banned_id[index].replace("*", "\\w");

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(pattern)) {
                visited[i] = true;
                currentSet.add(user_id[i]);
                dfs(user_id, banned_id, index + 1, currentSet, visited, resultSet);
                currentSet.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }
}
