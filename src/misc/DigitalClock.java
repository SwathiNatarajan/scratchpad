package misc;

import java.util.*;


public class DigitalClock {

  private List<Integer> linkedList;

  public DigitalClock(List<Integer> linkedList) {
    this.linkedList = new LinkedList<>();
    this.linkedList.addAll(linkedList);

  }

  public DigitalClock(Integer... nums) {
    this.linkedList = new LinkedList<>();
    this.linkedList.addAll(Arrays.asList(nums));

  }

  public void buildClock() {
    Collections.sort(linkedList);
    if(linkedList.get(linkedList.size()-1) == 0){
      System.out.println("Impossible");
      return;
    }
    StringBuilder builder = new StringBuilder();
    try {

      buildHours(builder);
      if (!"12:00:00".equals(builder.toString())) {
        buildMinOrSec(builder);
        buildMinOrSec(builder);
      }
      System.out.println(builder.toString());
    } catch (IllegalArgumentException ignore) {

    }
  }

  public static void main(String[] args) {
//    int[] nums = {3, 3, 3, 3, 3, 3, 6, 7, 7};

    Scanner sc=new Scanner(System.in);
    sc.useDelimiter(",");
    List<Integer> list = new ArrayList<>();
    while(sc.hasNextInt()){
     int nextInt = sc.nextInt();
     if(nextInt<=9 && nextInt >=0 && (!list.isEmpty()&&list.get(list.size()-1)<=nextInt && list.size()<9)) {
       list.add(nextInt);
     }else{
       System.out.println("Incorrect input sequence");
       System.exit(0);
      }

    }

    if(list.size() ==9) {

      DigitalClock clock = new DigitalClock(list);
      clock.buildClock();
    }else {
      System.out.println("Impossible");
    }

  }

  private void buildHours(StringBuilder builder) {
    int zLastIndex = -1;
    int oLastIndex = -1;
    int tLastIndex = -1;

    if (linkedList.contains(0)) {
      zLastIndex = linkedList.lastIndexOf(0);
    }
    if (linkedList.contains(1)) {
      oLastIndex = linkedList.lastIndexOf(1);
    }

    if (linkedList.contains(2)) {
      tLastIndex = linkedList.lastIndexOf(2);
    }

    if (!((zLastIndex > -1 && oLastIndex > -1) || zLastIndex > 0 || oLastIndex > 0)) {
      System.out.println("Impossible");
      throw new IllegalArgumentException("Impossible to Build");
    }

    if (zLastIndex == 3 && tLastIndex > -1) {
      builder.append(1).append(2)
        .append(":").append(0).append(0).append(":").append(0).append(0);

    } else if (oLastIndex > 0 && oLastIndex != linkedList.indexOf(1)) {
      builder.append(1).append(1);

      linkedList.remove(oLastIndex);
      linkedList.remove(linkedList.indexOf(1));

    } else if (oLastIndex > -1 && zLastIndex > -1) {
      builder.append(1).append(0);

      linkedList.remove(linkedList.indexOf(1));
      linkedList.remove(linkedList.indexOf(0));
    } else if (zLastIndex > -1) {
      builder.append(0).append(linkedList.get(linkedList.size() - 1));
      linkedList.remove(linkedList.indexOf(0));
      linkedList.remove(linkedList.get(linkedList.size() - 1));
    }
  }

  private void buildMinOrSec(StringBuilder builder) {
    int maxMin = findMinIndex(linkedList, 5);
    if (maxMin == -1) {
      System.out.println("Impossible");
      throw new IllegalArgumentException("Impossible to Build");
    } else {
      builder.append(":");
      builder.append(linkedList.get(maxMin)).append(linkedList.get(linkedList.size() - 1));
      linkedList.remove(maxMin);
      linkedList.remove(linkedList.get(linkedList.size() - 1));
    }
  }

  private static int findMinIndex(List<Integer> nums, int maxNum) {
    int minIndex = -1;
    for (int i = nums.size() - 1; i >= 0; i--) {
      if (nums.get(i) <= maxNum) {
        minIndex = i;
        break;
      }
    }
    return minIndex;
  }
}
