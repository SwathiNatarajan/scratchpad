package sort;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by thotap on 4/30/2017.
 */
public class LongestSubList {
  public static void main(String[] args) {
    int[] nums={4,5,1,5,7,6,8,4,1};
//    int[] sortedNums = new int[0];
//     System.arraycopy(nums, 0, sortedNums, 0, nums.length);
//     Arrays.sort(sortedNums);
     List<Integer> maxSubList = new ArrayList<>();
     for(int i=0; i<nums.length; i++){
       for(int k=i; k<nums.length; k++) {
         int minIndex = findMinIndex(nums, i, k);

         int expectedSum = ((k - i + nums[minIndex]) * (k - i +1+ nums[minIndex]) / 2)-( (nums[minIndex]-1)* (nums[minIndex]) /2);
         int actualSum = 0;
         for (int l = i; l <= k; l++) {
           actualSum += nums[l];
         }
         if (actualSum == expectedSum) {
           int[] subList = new int[k-i+1];

           System.arraycopy(nums, i, subList, 0, k - i+1);
           if(maxSubList.size() < subList.length){
             maxSubList = new ArrayList<>();
             for (int num : subList) {
               maxSubList.add(num);
             }
           }
           System.out.print(" sub list ");
           for (int num : subList) {
             System.out.print(num);
           }
         }
       }

     }
    System.out.println();
    if(!maxSubList.isEmpty()){
      System.out.println("maxSubList = " + maxSubList);
    }
  }

  private static int findLargeSubList(List<List<Map.Entry<Integer, Integer>>> subEntryLists){
    int prevMinIndex=0;
    for(int j=0; j<subEntryLists.size();j++){
      if(subEntryLists.get(prevMinIndex).size() > subEntryLists.get(j).size()){
        prevMinIndex = j;
      }
    }
    return prevMinIndex;

  }

  private static int findMinIndex(int[] nums,  int start, int end){
    int minIndex = start;

    for(int i=start; i<=end; i++){
      if(nums[minIndex] > nums[i]){
        minIndex=i;
      }
    }
    return minIndex;
  }
}
