class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //brute force 
        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            boolean flag = false;

            for(int j= i+1 ; j<nums.length;j++){
                if(nums[j]>nums[i]){
                    ans[i]=nums[j];
                    flag = true;
                    break;
                }
            }

            if(!flag){
                for(int j=0;j<i;j++){
                    if(nums[j]>nums[i]){
                        ans[i]=nums[j];
                    flag = true;
                    break;
                    }
                }
            }
            if(!flag){
                ans[i]=-1;
            }
        }
        return ans;
    }
}