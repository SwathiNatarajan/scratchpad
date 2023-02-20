package sort;

/**
 * Created by thotap on 4/30/2017.
 */
public class BubbleSort {
  public static void main(String[] args) {
    int[] nums = {5,4,1,2,8};
//    for(int i=0; i<nums.length; i++){
//      for(int j=0; j<nums.length-1;j++){
//        if(nums[j] > nums[j+1]){
//          swap(nums, j, j+1);
//        }
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

  private static  void sort(int[] nums, int start){
    if(start < nums.length) {
      for (int j = 0; j < nums.length - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
        }
      }
      sort(nums, ++start);
    }
  }
}
