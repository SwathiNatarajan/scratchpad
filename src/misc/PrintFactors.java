package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thotap on 5/22/2017.
 */
public class PrintFactors {
  public static void main(String[] args) {
    int num = 12;

    int factor = 2;

    printFactors(12, "", 12);
  }

  private static void factorCom(int num, List<Integer> result) {
   if(num > 2)
    for(int i=2; i<num/2; i++){
      if(num%i == 0){
        int divisor = num/i;
        result.add(divisor);

          factorCom(i, result);

      }
    }
  }

  public static void printFactors(int number, String parentFactors, int parentVal) {
    int newVal = parentVal;
    for (int i = number/2; i >= 2; i--) {

      if (number % i == 0) {
        if (newVal > i) {
          newVal = i;
        }
        if (number / i <= parentVal && i <= parentVal
          && number / i <= i) {
          System.out.println(parentFactors + i + "*" + number / i);
          newVal = number / i;
        }

        if (i <= parentVal) {
          printFactors(number / i, parentFactors + i + "*", newVal);
        }
      }

    }

  }
}
