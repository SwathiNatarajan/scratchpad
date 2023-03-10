package list;

public class RotatedArray {


    // Find min element is sorted but rotated array.
    // Binary search is the key!!!
    public int findMin(int[] nums, int left, int right) {
        if (right < left) {
            return nums[0];
        }
        if (left == right) {
            return nums[left];
        }
        int mid = (right + left) / 2;
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (right > mid && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if (nums[right] < nums[mid]) {
            // look in the right
            return findMin(nums, mid + 1, right);
        } else {
            // look in the left
            return findMin(nums, left, mid - 1);
        }
    }

    // Find element in a rotated sorted array

    //Input: nums = [4,5,6,7,0,1,2], target = 0
    //Output: 4  (TODO: INCOMPLETE)
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (target == nums[mid]) {
            return mid;
        }

        if( nums[mid+1] == target){
            return mid+1;
        }

        if(nums[mid-1] == target){
            return mid-1;
        }

        if(nums[mid+1] < target && nums[right] > target){
            return search(nums, mid + 1, right, target);
        }

        if(nums[mid-1] > target && nums[left] <target){
            return search(nums, left, mid-1, target);
        }

        if (target > nums[mid]) {
            // check on right
            return search(nums, mid + 1, right, target);
        } else {
            // check on left
            return search(nums, left, mid - 1, target);
        }

    }

}
