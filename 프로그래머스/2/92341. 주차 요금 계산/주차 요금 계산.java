import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        for(String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String car = parts[1];
            String type = parts[2];
            
            int minutes = toMinutes(time);
            
            if(type.equals("IN")) {
                inMap.put(car, minutes);
            } else {
                int inTime = inMap.remove(car);
                totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + (minutes - inTime));
            }
        }
        
        for(String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + (toMinutes("23:59") - inTime));
        }
        
        List<String> cars = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(cars);
        
        
        int[] answer = new int[cars.size()];
        for(int i = 0; i < cars.size(); i++) {
            int total = totalTimeMap.get(cars.get(i));
            answer[i] = calculateFee(fees, total);
        }
        
        return answer;
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    private int calculateFee(int[] fees, int total) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(total <= baseTime) return baseFee;
        
        return baseFee + (int)Math.ceil((total - baseTime) / (double) unitTime) * unitFee;
    }
}