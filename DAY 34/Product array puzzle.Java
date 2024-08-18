class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long left=1;
        
        long right[] = new long[n];
        
        right[n-1]=1;
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1]*nums[i+1];
        }
        long ans[] = new long[n];
        for(int i =0; i<n; i++){
            ans[i] = left*right[i];
            left = left*nums[i];
            
        }
        return ans;
    }
}
