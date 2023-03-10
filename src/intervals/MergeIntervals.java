package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // it is necessary to sort
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int len = 0;
        result.add(len, intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int rs = result.get(len)[0];
            int re = result.get(len)[1];
            if (re >= start) {
                int ns = Math.min(rs, start);
                int ne = Math.max(re, end);
                result.remove(len);
                result.add(len, new int[]{ns, ne});
            } else {
                result.add(++len, new int[]{start, end});
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
