import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> nSet = new HashSet<>();
        
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited, nSet);

        for(int i : nSet) {
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    private void dfs(String current, String numbers, boolean[] visited, Set<Integer> nSet) {
        if (!current.isEmpty()) {
            nSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited, nSet);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        int sqrt = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
