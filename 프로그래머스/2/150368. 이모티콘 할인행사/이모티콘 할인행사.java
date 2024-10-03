import java.util.*;

class Solution {
    static int[] discountRates = {10, 20, 30, 40};
    static int maxSubscribers = 0;
    static int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        findBestDiscounts(users, emoticons, new int[emoticons.length], 0);
        
        return new int[] {maxSubscribers, maxSales};
    }

    private void findBestDiscounts(int[][] users, int[] emoticons, int[] discounts, int depth) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, discounts);
            return;
        }

        for (int rate : discountRates) {
            discounts[depth] = rate;
            findBestDiscounts(users, emoticons, discounts, depth + 1);
        }
    }

    private void calculate(int[][] users, int[] emoticons, int[] discounts) {
        int subscribers = 0;
        int sales = 0;

        for (int[] user : users) {
            int userDiscountRate = user[0];
            int userMaxPrice = user[1];
            int userTotalPrice = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userDiscountRate) {
                    userTotalPrice += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            if (userTotalPrice >= userMaxPrice) {
                subscribers++;
            } else {
                sales += userTotalPrice;
            }
        }

        if (subscribers > maxSubscribers || (subscribers == maxSubscribers && sales > maxSales)) {
            maxSubscribers = subscribers;
            maxSales = sales;
        }
    }
}
