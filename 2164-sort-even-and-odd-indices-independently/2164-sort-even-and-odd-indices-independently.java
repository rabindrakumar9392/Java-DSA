import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0){
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
Collections.sort(odd, Collections.reverseOrder());        
       int evenIdx = 0;
       int  oddIdx = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                nums[i] = even.get(oddIdx++);
            } else {
                nums[i] = odd.get(evenIdx++);
            }
        }
        return nums;
    }
}