class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String num : arr) {
            int number = Integer.parseInt(num);
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return min + " " + max;
    }

}