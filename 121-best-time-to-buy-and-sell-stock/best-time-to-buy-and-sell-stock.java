class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i:prices){
            minPrice = Math.min(minPrice,i);
            maxProfit = Math.max(maxProfit,i-minPrice);
        }

        return maxProfit;
    }
}