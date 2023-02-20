package slidingWindow;

public class MinSubArray {

    // Input: target = 7, nums = [2,3,1,2,4,3]
    //Output: 2
    //Explanation: The subarray [4,3] has the minimal length under the problem constraint.

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        // start at 0
        // add start to sum
        // check if sum is greater or equal to target
        //    if yes , maxLen = end - start; sum = 0 ; start++;
        //    no , add nums[end] to sum
        //    repeat check
        while (start < n) {
            sum += nums[start];
            while (sum >= target) {
                minLen = Math.min(start + 1 - end, minLen);
                sum -= nums[end++];
            }
            start++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
