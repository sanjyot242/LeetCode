class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0 , right = height.length-1;

        while(left<right){
         int w = right-left;
         int l = Math.min(height[left],height[right]);
         int area = w*l;
         maxArea = Math.max(maxArea,area);

         if(height[left]<height[right]){
            left++;
         }else if(height[left]>height[right]){
            right--;
         }else{
            left++;
            right--;
         }

        }

        return maxArea;
    }
}