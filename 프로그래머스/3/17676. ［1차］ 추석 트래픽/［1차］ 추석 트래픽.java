import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Solution {
    public int solution(String[] lines) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<int[]> times = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(" ");
            Date endDate = dateFormat.parse(parts[0] + " " + parts[1]);
            long endTime = endDate.getTime();
            long duration = (long)(Double.parseDouble(parts[2].substring(0, parts[2].length() - 1)) * 1000);
            long startTime = endTime - duration + 1;

            times.add(new int[]{(int) startTime, (int) endTime});
        }

        int maxTraffic = 0;

        for (int i = 0; i < times.size(); i++) {
            int startWindow = times.get(i)[1];
            int endWindow = startWindow + 1000;

            int traffic = 0;

            for (int[] time : times) {
                if (time[1] >= startWindow && time[0] < endWindow) {
                    traffic++;
                }
            }

            maxTraffic = Math.max(maxTraffic, traffic);
        }

        return maxTraffic;
    }
}