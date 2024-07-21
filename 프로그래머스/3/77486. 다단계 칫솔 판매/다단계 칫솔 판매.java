import java.util.*;

class Node{
        String parent;
        int idx;

        public Node(String parent, int idx){
            this.parent = parent;
            this.idx = idx;
        }
}

class Solution {
    int[] answer;
    Map<String, Node> member = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) 
            member.put(enroll[i],new Node(referral[i], i));
        
        for (int i = 0; i < seller.length; i++) 
            distributeProfit(seller[i], amount[i] * 100);
        
        return answer;
    }

    void distributeProfit(String seller, int amount){
        while (!seller.equals("-")) {
            Node node = member.get(seller);
            
            int profit = amount - amount / 10;
            answer[node.idx] += profit;
            amount /= 10;
            
            if (amount < 1) break;
            seller = node.parent;
        }
    }
}