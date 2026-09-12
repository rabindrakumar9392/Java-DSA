class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;

        while(right<nums.length){
            if(left==right){
                right++;
                continue;
            }
        int diff = nums[right] - nums[left];
        if(diff<k){
            right++;
        } else if(diff>k){
            left++;
        } else {
            count++;

            int leftVal = nums[left];
            int rightVal = nums[right];
            while(left < nums.length && leftVal == nums[left]){
                left++;
            }
           while(right < nums.length && rightVal == nums[right]){ 
            right++; 
            }

        }
        }
        return count;
       
    }
}