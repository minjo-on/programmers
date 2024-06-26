import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftRecords = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();

        for (String friend : friends) {
            giftRecords.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            nextMonthGifts.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            int currentGifts = giftRecords.getOrDefault(giver, new HashMap<>()).getOrDefault(receiver, 0);
            giftRecords.get(giver).put(receiver, currentGifts + 1);

            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.getOrDefault(receiver, 0) - 1);
        }

        for (String giver : friends) {
            for (String receiver : friends) {
                if (!giver.equals(receiver)) {
                    int giftsFromGiver = giftRecords.getOrDefault(giver, new HashMap<>()).getOrDefault(receiver, 0);
                    int giftsFromReceiver = giftRecords.getOrDefault(receiver, new HashMap<>()).getOrDefault(giver, 0);
                    if (giftsFromGiver > giftsFromReceiver ||
                        (giftsFromGiver == giftsFromReceiver && giftScore.get(giver) > giftScore.get(receiver))) {
                        nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                    }
                }
            }
        }

        int maxGiftsNum = 0;
        for (int giftsNum : nextMonthGifts.values()) {
            if (giftsNum > maxGiftsNum) {
                maxGiftsNum = giftsNum;
            }
        }
        return maxGiftsNum;
    }
}