class Solution {
    public int trap(int[] height) {
        int left = 0 , right = height.length-1 , maxLeft = 0 , maxRight = 0 ;
        int res =0 ;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>= maxLeft){
                maxLeft = height[left];
                }else{
                 res += maxLeft - height[left];
                }
                left++;
            }else{
               if(height[right]>=maxRight){
                   maxRight = height[right];
               }else{
                   res += maxRight - height[right];
               }
               right--;
            }
        }
        return res;
    }
}

//Brute Force
// class Solution {
//     public int trap(int[] height) {
       
//         int res = 0 ;
        
//         for (int i = 0 ; i < height.length;i++){
//             int maxLeft =0,maxRight=0;
//             int j = i ;
//             while(j<height.length){
//                 maxRight = Math.max(maxRight,height[j]);
//                 j++;
//             }
//             j=i;
//             while(j>=0){
//                 maxLeft = Math.max(maxLeft,height[j]);
//                 j--;
//             }

//             res += Math.min(maxLeft,maxRight)- height[i];
//         }
//         return res;
//     }
// }
