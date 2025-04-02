class Solution {
    public int[] solution(int[][] arr) {
        return count(0, 0, arr.length, arr);
    }
    
    public int[] plusArr(int[] arr1, int[] arr2) {
        return new int[]{arr1[0] + arr2[0], arr1[1] + arr2[1]};
    }
    
    public int[] count(int y, int x, int size, int[][] arr) {
        int[] answer = new int[]{0, 0};
        
        int prev = arr[y][x];
        
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){  
                if(prev != arr[i][j]){
                    int next = size / 2;
                    answer = plusArr(answer, count(y, x, next, arr));
                    answer = plusArr(answer, count(y + next, x, next, arr));
                    answer = plusArr(answer, count(y, x + next, next, arr));
                    answer = plusArr(answer, count(y + next, x + next, next, arr));
                    return answer;
                }
            }
        }
        
        return arr[y][x] == 0 ? new int[]{1, 0} : new int[]{0, 1};
    }
    
    
}