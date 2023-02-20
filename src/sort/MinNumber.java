package sort;

/**
 * Created by thotap on 5/1/2017.
 */
public class MinNumber {

  public static void main(String[] args) {
    int[] nums = {60,20,30,10,80,50};
    Window window = new Window(3, nums);
    int minNumber = ((Double)Math.pow(2,32)).intValue()-1;
    while (window.hasNext()){
      int[] currentWindow =  window.getNums();
      int currentMin = currentWindow[findMinIdex(currentWindow)];
      if(currentMin<minNumber){
        minNumber = currentMin;
      }
    }

    System.out.println("min num: " + minNumber);

  }

  public static int findMinIdex(int[] nums){
    int minIndex = 0;
    for(int i=0; i<nums.length; i++){
      if(nums[minIndex] > nums[i]){
        minIndex=i;
      }
    }
    return minIndex;
  }
}

class Window{
  int size;
  int[] nums;
  int index;

  public Window(int size, int[] nums) {
    this.size = size;
    this.nums = nums;
  }

  public int[] getNums(){
    if(!hasNext()){
      throw  new IllegalStateException("No elements present");
    }
    int tempSize = nums.length-index>size? size:nums.length-index;
    int[] tempAry =  new int[tempSize];
    System.arraycopy(nums, index, tempAry, 0 , tempSize);
    index++;
    return tempAry;
  }

  public boolean hasNext(){
    return index != nums.length;
  }


}
