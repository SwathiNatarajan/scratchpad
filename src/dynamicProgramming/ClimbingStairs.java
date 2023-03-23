package dynamicProgramming;

public class ClimbingStairs {

    // not good impl, times out for large data.
    public int findMaxLength(int[] nums) {
        int countOne = 0, countZero = 0, i = 0, maxLen = Integer.MIN_VALUE;
        while (i < nums.length-1) {
            if (nums[i] == 0) {
                countZero++;
            }
            if (nums[i] == 1) {
                countOne++;
            }
            int j = i+1;
            while (j < nums.length) {
                if (nums[j] == 0) {
                    countZero++;
                }
                if (nums[j] == 1) {
                    countOne++;
                }
                if (countZero == countOne) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                j++;
            }
            countZero=0;
            countOne=0;
            i++;
        }
        return Math.max(maxLen,0);
    }

    public static void main(String[] args) {
        new ClimbingStairs().findMaxLength(new int[]{0,1,0});
    }
}
