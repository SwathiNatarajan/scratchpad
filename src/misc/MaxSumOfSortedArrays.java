package misc;

import java.util.Arrays;

/**
 * Created by thotap on 5/2/2017.
 */
public class MaxSumOfSortedArrays {
  public static void main(String[] args) {
    int[] a = {1,2,4,6,7,9,10};
    int[] b = {1, 2,3,4,5,6,7,8};
    String[] path = new String[Math.max(a.length, b.length)];
    int sum=0;
    for(int i=0; i< Math.max(a.length, b.length); i++){
      if(i < a.length && i < b.length){
        if(a[i]>b[i]){
          path[i] = "a["+i + "]" + "="+a[i];
          sum+=a[i];
        }else{
          path[i] = "b["+i + "]" + "="+b[i];
          sum+=b[i];
        }
      }else if(i < a.length){
        path[i] = "a["+i + "]" + "="+a[i];
        sum+=a[i];
      }else if(i < b.length){
        path[i] = "b["+i + "]" + "="+b[i];
        sum+=b[i];
      }
    }
    System.out.println("sum = " + sum);
    System.out.println("Arrays.toString(path = " + Arrays.toString(path));
  }
}
