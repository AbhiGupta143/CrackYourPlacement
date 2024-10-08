class Solution {
    public int findDuplicate(int[] nums) {
        // start a fast and slow pointer 
        // until they meet
        int slow = 0, fast =0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while ( slow != fast);

        // AS soon as they meet , move both
        // pointers at the same speed until they meet again
        slow = 0;
        while ( slow != fast ){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
