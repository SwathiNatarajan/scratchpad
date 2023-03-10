package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int i = 0, j=0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1Len && j < nums2Len) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[result.size()];
        for (int l = 0; l < result.size(); l++) {
            res[l]=result.get(l);
        }
        return res;
    }
}
