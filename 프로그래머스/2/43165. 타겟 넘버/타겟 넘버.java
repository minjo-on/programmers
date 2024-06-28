class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int currentValue){
        int count = 0;
        
        if(numbers.length == depth){
            if(target == currentValue) return 1;
            return 0;
        }
        
        int p = currentValue + numbers[depth];
        int m = currentValue - numbers[depth];
        
        count += dfs(numbers,target,depth+1, p);
        count += dfs(numbers,target,depth+1, m);
        
        return count;
    }
}