class Solution {
    private int numOfSubarraysLessThan(int[] num, int k){
        int l=0,r=0,sum=0,count=0;
        if(k<0) return 0;
        while(r<num.length){
            sum += num[r]%2;
            while(sum > k){
                sum = sum - num[l]%2;
                l = l+1;
            }
            count = count + (r-l+1);
            r = r+1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
         return numOfSubarraysLessThan(nums,k) -  numOfSubarraysLessThan(nums,k-1);
    }
}