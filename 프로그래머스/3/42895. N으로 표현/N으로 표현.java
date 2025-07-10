import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            dp.add(new HashSet<>());
        }

        for (int i = 0; i < 8; i++){
            String numStr = String.valueOf(N).repeat(i + 1);
            dp.get(i).add(Integer.parseInt(numStr));
            
            for (int j = 0; j < i; j++){
                for (int a : dp.get(j)){
                    for (int b : dp.get(i - j - 1)){
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
                
            } 
            if (dp.get(i).contains(number)) return i + 1;
        }
        return -1;
    }
}