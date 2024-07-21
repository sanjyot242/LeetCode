class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int multiply = 1;
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = multiply ;
            multiply *= nums[i];
        }

        multiply = 1;
        for(int j=n-1 ; j>=0; j--){
            ans[j] *= multiply ;
            multiply *= nums[j];
        }

        return ans;
    }
}