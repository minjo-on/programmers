class Solution {
    public int solution(int[][] sizes) {
    int maxWidth = 0;
    int maxHeight = 0;

    for (int[] size : sizes) {
        int rWidth = Math.max(size[0], size[1]);
        int rHeight = Math.min(size[0], size[1]);

        maxWidth = Math.max(maxWidth, rWidth);
        maxHeight = Math.max(maxHeight, rHeight);
    }

    return maxWidth * maxHeight;
}

}