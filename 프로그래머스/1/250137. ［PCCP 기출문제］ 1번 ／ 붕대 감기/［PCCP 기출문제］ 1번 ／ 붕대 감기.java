import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int seconds = attacks[attacks.length-1][0];
        int hp = health;
        int count = 0;

        HashMap<Integer, Integer> attacksMap = Arrays.stream(attacks).collect(Collectors.toMap(key -> key[0],value -> value[1],(k,v)->v,HashMap::new));

        for(int i = 1; i <= seconds; i++){
            if(attacksMap.containsKey(i)){
                count = 0;
                int attackValue = attacksMap.get(i);
                hp -= attackValue;
                if(hp <= 0) return -1;
                
            }else {
                count += 1;
                hp += bandage[1];
                if(count == bandage[0]){
                    hp += bandage[2];
                    count = 0;
                }
                if(hp >= health) hp = health;
            }
        }
        return hp;
    }
}