
import java.util.*;

class Solution {

    int[] result;
    int[] indices;
    int[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        result = new int[n];
        indices = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, 0, n - 1);

        List<Integer> ans = new ArrayList<>();
        for (int count : result) {
            ans.add(count);
        }
        return ans;
    }
    void mergeSort(int[] nums, int left, int right) {

        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int rightSmallerCount = 0;
        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                rightSmallerCount++;
            } else {
                result[indices[i]] += rightSmallerCount;
                temp[k++] = indices[i++];
            }
        }
        while (i <= mid) {
            result[indices[i]] += rightSmallerCount;
            temp[k++] = indices[i++];
        }
        while (j <= right) {
            temp[k++] = indices[j++];
        }
        for (int x = left; x <= right; x++) {
            indices[x] = temp[x];
        }
    }
}
