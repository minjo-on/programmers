import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i < 9; i++){
            list.add(new ArrayList<>());
            String repeat = String.valueOf(N).repeat(i);
            list.get(i - 1).add(Integer.parseInt(repeat));
        }

        for (int i = 1; i < 8; i++){
            for (int j = 0; j < i; j++){
                for (int a : list.get(j)){
                    for (int b : list.get(i - j - 1)){
                        list.get(i).add(a + b);
                        list.get(i).add(a - b);
                        list.get(i).add(a * b);
                        if (b != 0) list.get(i).add(a / b);
                    }
                }
                
            }
            if (list.get(i).contains(number)) return i + 1;
        }
        return -1;
    }
}