import java.util.*;

class Solution {
    private HashMap<Long, Long> roomMap = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findAvailableRoom(room_number[i]);
        }

        return answer;
    }

    private long findAvailableRoom(long room) {
        if (!roomMap.containsKey(room)) {
            roomMap.put(room, room + 1); 
            return room;
        }

        long nextRoom = findAvailableRoom(roomMap.get(room));
        roomMap.put(room, nextRoom);
        return nextRoom;
    }
}