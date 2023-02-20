package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by thotap on 7/21/2017.
 */
public class Partitions {
  private static int counter;
  static List<List<Integer>> stackList = new ArrayList<>();

  public static void main(String[] args) {
    List<Integer> stack = new ArrayList<>();

    partitions(10,2,1, stack);

  }

  private static void partitions(int n, int k, int start, List<Integer> stack){


    if(start+k>=n){
//      if(!stack.isEmpty()) {
//        stack.pop();
//      }
      stackList.add(stack);
      return;
    }
    for(int i=start; i < n/2 ; i++, stack = new ArrayList<>()){
      if(!stack.isEmpty()){
        int pop = stack.get(stack.size()-1);

        if(i-pop >= k && (n-i-i >= k)){
          System.out.print(pop + " + ");
          System.out.println(i + " + " + (n-i));

          stack.add(i);
          stack.add(n-i);
        }
      } else{
        if((n-i-i >= k)) {
          System.out.println(i + " + " + (n - i));
          stack.add(i);
          stack.add(n-i);
        }
//        if(start+k <= (n-i)){
//          stack.add(i);
//        }

      }

      partitions(n-i, k, start+k, stack);

    }
    System.out.println("stackList = " + stackList);
    stack = new ArrayList<>();
  }



  public static boolean divisibleBy2or3(int i){
 return i%2==0||i%3==0;
  }
}
