class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int current){
        if(depth == numbers.length) return target == current ? 1 : 0;
        
        return dfs(numbers, target, depth + 1, current + numbers[depth]) + 
            dfs(numbers, target, depth + 1, current - numbers[depth]);
    }
}