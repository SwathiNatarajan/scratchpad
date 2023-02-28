package stringandarray;

public class RotateArray {

    public void rotate(int k, int[] nums) {

        int length = nums.length;

        // 1,2,3,4,5
        // rotate right by 2
        // 4,5,1,2,3
        // rotate right by 3
        // 1,2,3,4,     5
        // rotate right by 1
        // 5,1,2,3,4

        // split the array by k from end for right rotation
        // int mid = length/k;
        // copy mid +1 to end to
        // merge sort

        int mid = k % length;
        rotate(nums, 0, length-1);
        rotate(nums, 0, mid-1);
        rotate(nums, mid, length-1);
    }

    private void rotate(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{1,2,3,4,5};
        new RotateArray().rotate(3, nums);
    }
}
