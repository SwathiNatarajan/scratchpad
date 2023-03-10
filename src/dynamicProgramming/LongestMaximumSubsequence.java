package dynamicProgramming;

public class LongestMaximumSubsequence {

    private int findMid(int[] tails, int left, int right, int k) {
        while (right - 1 > left) {
            int mid = left + (right-left) / 2;
            if (tails[mid] >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public int longestIncreasingSequence(int[] nums, int size){
        int[] tailTable = new int[nums.length];
        if(nums.length<2){
            return 1;
        }
        tailTable[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tailTable[0]) {
                // indicates start of new sequence
                tailTable[0] = nums[i];
            } else if (nums[i] > tailTable[len - 1]) {
                // append to the existing sequence
                // if the last element is smaller than current
                tailTable[++len] = nums[i];
            } else {
                // find out where to insert this new num
                // and discard the ones greater
                tailTable[findMid(tailTable,0, tailTable.length, nums[i])] = nums[i];
            }
        }
        return tailTable.length;
    }
}
