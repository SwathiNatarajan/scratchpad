package stringandarray;

public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 6, 7};
        new BinarySearch().binarySearch(nums, 0, nums.length - 1, 7);
    }

    public boolean binarySearch(int[] nums, int start, int end, int k) {
        int mid = (start + end) / 2;
        if (nums[mid] == k) {
            return true;
        }
        if (nums[mid] < k) {
            return binarySearch(nums, start, mid, k);
        }
        return binarySearch(nums, mid + 1, end, k);
    }
}
