package misc;

/**
 * Created by thotap on 5/2/2017.
 */
public class DuplicateNums {

  public static void main(String[] args) {
    int[] nums = {1,1,2,2,3,4,4,5,5,6,6,7,7,8,9,9};
    int num=0;
    int i=0;
    while(i<nums.length){
      num=nums[i]^nums[i+1];
      if(num!=0){
        System.out.println("non-repeated num "+ nums[i]);
        i++;
      }else{
        i=i+2;
      }


    }

    System.out.println("1^1= " + (2^2));

  }
}
