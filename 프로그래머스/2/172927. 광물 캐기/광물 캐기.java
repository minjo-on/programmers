import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int cnt = Math.min((minerals.length + 4) / 5, totalPicks);
        int[][] section = new int[cnt][3];

        for (int i = 0; i < cnt; i++) {
            int dp = 0, ip = 0, sp = 0;
            for (int j = i * 5; j < Math.min((i + 1) * 5, minerals.length); j++) {
                switch (minerals[j]) {
                    case "diamond":
                        dp += 1;
                        ip += 5;
                        sp += 25;
                        break;
                    case "iron":
                        dp += 1;
                        ip += 1;
                        sp += 5;
                        break;
                    default:
                        dp += 1;
                        ip += 1;
                        sp += 1;
                        break;
                }
            }
            section[i][0] = dp;
            section[i][1] = ip;
            section[i][2] = sp;
        }

        Arrays.sort(section, (a, b) -> Integer.compare(b[2], a[2]));

        int answer = 0;
        for (int i = 0; i < cnt; i++) {
            if (picks[0] > 0) {
                answer += section[i][0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += section[i][1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += section[i][2];
                picks[2]--;
            }
        }

        return answer;
    }
}
