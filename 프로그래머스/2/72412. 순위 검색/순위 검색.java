import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infoMap = new HashMap<>();

        for (String i : info) {
            String[] parts = i.split(" ");
            int score = Integer.parseInt(parts[4]);
            addToMap(infoMap, "", parts, 0, score);
        }

        for (List<Integer> list : infoMap.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] parts = query[i].replace(" and ", " ").split(" ");
            String key = String.join("", Arrays.copyOf(parts, 4));
            int score = Integer.parseInt(parts[4]);

            answer[i] = countCandidates(infoMap.getOrDefault(key, new ArrayList<>()), score);
        }

        return answer;
    }

    private void addToMap(Map<String, List<Integer>> map, String prefix, String[] parts, int depth, int score) {
        if (depth == 4) {
            map.computeIfAbsent(prefix, k -> new ArrayList<>()).add(score);
            return;
        }
        addToMap(map, prefix + parts[depth], parts, depth + 1, score);
        addToMap(map, prefix + "-", parts, depth + 1, score);
    }

    private int countCandidates(List<Integer> scores, int target) {
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return scores.size() - left;
    }
}