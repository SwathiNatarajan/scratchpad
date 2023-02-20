package slidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinSubArrayTest {

    @Test
    public void testMinSubArrayLen() {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        MinSubArray minSubArray = new MinSubArray();
       Assertions.assertEquals(2, minSubArray.minSubArrayLen(target, nums));
        Assertions.assertEquals(1, minSubArray.minSubArrayLen(4, new int[]{1,4,4}));
       Assertions.assertEquals(0, minSubArray.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
