import java.util.*;

class Solution {
    Map<Long, Long> roomMap = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }
        
        return answer;
    }
    
    private long findRoom(long room) {
        if(!roomMap.containsKey(room)){
            roomMap.put(room, room + 1);
            return room;
        }
        
        long nextRoom = findRoom(roomMap.get(room));
        roomMap.put(room, nextRoom);
        return nextRoom;
    }
}