package sort;

import java.util.Arrays;

/**
 * Created by thotap on 5/2/2017.
 */
public class KthSmallNumber {
  public static void main(String[] args) {
    int[] nums={0,4,3,1,6,2,5,9,8};
    sort(nums, 0, 5);
    System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    System.out.println("Kth small " + nums[5]);
  }

  private static int findMinIndex(int[] nums, int start){
    int minIndex = start;
    for(int i=start; i<nums.length; i++){
      if(nums[minIndex] > nums[i]){
        minIndex = i;
      }
    }
    return minIndex;
 }

 private static void sort(int[] nums, int start, int index){
   int minIndex=start;
    for(int i=start; i<nums.length; i++){

      int currentMin = findMinIndex(nums, i);
      if(minIndex!=currentMin){
        swap(nums, i, currentMin);

      }
      minIndex = i;

      if(i==index){
        break;
      }

    }
 }

  private static void swap(int[] nums, int i, int j){
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

}
