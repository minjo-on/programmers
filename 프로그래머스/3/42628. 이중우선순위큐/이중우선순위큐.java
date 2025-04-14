import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations){
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if(cmd.equals("D")){
                if(map.isEmpty()) continue;
                int key = value == 1 ? map.lastKey() : map.firstKey();
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            } else {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }
        
        return map.isEmpty() ? new int[]{0, 0} : new int[]{map.lastKey(), map.firstKey()};
    }
}