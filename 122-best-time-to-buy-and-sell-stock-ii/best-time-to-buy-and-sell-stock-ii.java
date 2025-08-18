class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];
        for(int i:prices){
            if(start < i){
                max = max+(i-start);
            }
            start = i ;
        }
        return max;
    }
}