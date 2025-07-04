function solution(nums) {
    const pick = nums.length / 2;
    const unique = new Set(nums).size;
    return Math.min(pick, unique);
}
