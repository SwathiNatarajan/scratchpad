package misc;

/**
 * Created by thotap on 4/28/2017.
 */
public class StampCalculator {
  static int[] stampDenomination = {50, 20,10, 5};
  public static void main(String[] args) {
    int[] stampDenomination = {50, 20,10, 5};
    int sum = 35;
    if(sum%5 !=0){
      System.out.println("Stamp calculation is not possible");
      return;
    }
//    int temp = sum;
//    for(int i=0;i<stampDenomination.length; i++){
//      int stampCost= stampDenomination[i];
//      if(temp >= stampCost){
//        int noOfStamps = temp/stampCost;
//        System.out.println("Denomination " + stampCost + ", no of stamps " + noOfStamps);
//        temp = temp - (noOfStamps * stampCost);
//        if(temp == 0){
//          break;
//        }
//      }
//    }

recursrive(sum, 0);
  }

  private static void recursrive(int temp, int denominationIndex) {
   if (stampDenomination.length > denominationIndex) {
      if (temp >= stampDenomination[denominationIndex]) {
        int noOfStamps = temp/stampDenomination[denominationIndex];
        System.out.println("Denomination " + stampDenomination[denominationIndex] + ", no of stamps " + noOfStamps);
        temp = temp - (noOfStamps * stampDenomination[denominationIndex]);
      }
    }
    if (temp > 0) {
      recursrive(temp, ++denominationIndex);
    }
  }
}
