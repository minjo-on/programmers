import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        for (int set = 1; set < (1 << colCount); set++) {
            if (isUnique(set, relation, rowCount, colCount)) {
                boolean isMinimal = true;
                for (int key : candidateKeys) {
                    if ((key & set) == key) {
                        isMinimal = false;
                        break;
                    }
                }
                
                if (isMinimal) {
                    candidateKeys.add(set);
                }
            }
        }
        
        return candidateKeys.size();
    }
    
    private boolean isUnique(int set, String[][] relation, int rowCount, int colCount) {
        Set<String> uniqueSet = new HashSet<>();
        
        for (int i = 0; i < rowCount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colCount; j++) {
                if ((set & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            
            if (!uniqueSet.add(sb.toString())) {
                return false;
            }
        }
        
        return true;
    }
}
