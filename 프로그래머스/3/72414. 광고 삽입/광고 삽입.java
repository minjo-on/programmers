class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSeconds(play_time);
        int advTime = toSeconds(adv_time);

        int[] views = new int[playTime + 1];

        for (String log : logs) {
            String[] parts = log.split("-");
            int start = toSeconds(parts[0]);
            int end = toSeconds(parts[1]);

            views[start] += 1;
            if (end < playTime) views[end] -= 1;
        }

        for (int i = 1; i <= playTime; i++) {
            views[i] += views[i - 1];
        }

        long maxView = 0;
        int bestStart = 0;
        long currentView = 0;

        for (int i = 0; i < advTime; i++) {
            currentView += views[i];
        }

        maxView = currentView;

        for (int i = advTime; i <= playTime; i++) {
            currentView += views[i] - views[i - advTime];
            if (currentView > maxView) {
                maxView = currentView;
                bestStart = i - advTime + 1;
            }
        }

        return toTimeFormat(bestStart);
    }
    
    int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 + Integer.parseInt(parts[1]) * 60 + Integer.parseInt(parts[2]);
    }

    String toTimeFormat(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds % 3600) / 60;
        int second = seconds % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}