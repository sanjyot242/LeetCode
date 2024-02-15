class Solution {
    public int trap(int[] height) {
       
        int res = 0 ;
        
        for (int i = 0 ; i < height.length;i++){
            int maxLeft =0,maxRight=0;
            int j = i ;
            while(j<height.length){
                maxRight = Math.max(maxRight,height[j]);
                j++;
            }
            j=i;
            while(j>=0){
                maxLeft = Math.max(maxLeft,height[j]);
                j--;
            }

            res += Math.min(maxLeft,maxRight)- height[i];
        }
        return res;
    }
}