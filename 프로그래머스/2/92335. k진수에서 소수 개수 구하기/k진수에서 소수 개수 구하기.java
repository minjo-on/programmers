class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String string = convertToBaseK(n, k);
        String[] arr = string.split("0");

        for (String s : arr) {
            if (!s.isEmpty() && isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    private String convertToBaseK(int number, int k) {
        return Integer.toString(number, k);
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        long sqrt = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
