package sort;

/**
 * Created by thotap on 4/30/2017.
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] nums = {5,4,1,2,8};
//    for(int i=0; i<nums.length; i++){
//      int prevMinIndex = findMinIndex(nums, i);
//      if (i!= prevMinIndex){
//        swap(nums, i, prevMinIndex);
//      }
//    }
    sort(nums,0);

    for(int num:nums){
      System.out.print(num + " ");
    }
  }

  private static void swap(int[] nums, int i, int j){
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  private static void sort(int[] nums, int start){
    if (start<nums.length){
      int prevMinIndex = findMinIndex(nums, start);
      if (start!= prevMinIndex){
        swap(nums, start, prevMinIndex);
      }
      sort(nums, ++start);
    }
  }

  private static int findMinIndex(int[] nums,  int start){
    int prevMinIndex=start;
    for(int j=start; j<nums.length;j++){
      if(nums[prevMinIndex] > nums[j]){
        prevMinIndex = j;
      }
    }
    return prevMinIndex;

  }
}
