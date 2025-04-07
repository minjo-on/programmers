import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> combiCountMap = new HashMap<>();
        
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for (int len : course) {
                if (chars.length >= len) {
                    combine(chars, len, 0, new StringBuilder(), combiCountMap);
                }
            }
        }
        
        List<String> answers = new ArrayList<>();

        for (int len : course) {
            int max = 0;
            List<String> tempList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : combiCountMap.entrySet()) {
                if (entry.getKey().length() == len && entry.getValue() >= 2) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        tempList.clear();
                        tempList.add(entry.getKey());
                    } else if (entry.getValue() == max) {
                        tempList.add(entry.getKey());
                    }
                }
            }

            answers.addAll(tempList);
        }

        Collections.sort(answers);
        return answers.toArray(new String[0]);
    }
    
    private void combine(char[] chars, int len, int start, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == len) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i = start; i < chars.length; i++){
            sb.append(chars[i]);
            combine(chars, len, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 
}