import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportingMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        Set<String> uniqueReport = new HashSet<>();
        
        for(String r : report) {
            uniqueReport.add(r);
        }
        
        for(String info : uniqueReport){
            String[] reportInfo = info.split(" ");
            
            String reporter = reportInfo[0];
            String reportingUser = reportInfo[1];
            
            Set<String> set = reportMap.getOrDefault(reporter, new HashSet<>());
            set.add(reportingUser);
            reportMap.put(reporter, set);

            reportingMap.put(reportingUser, reportingMap.getOrDefault(reportingUser, 0) + 1);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            Set<String> currentReport = reportMap.getOrDefault(id_list[i], new HashSet<>());
            
            for(String r : currentReport) {
                if(reportingMap.getOrDefault(r, 0) >= k) answer[i]++;
            }
        }
        
        return answer;
    }
}