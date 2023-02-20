package misc;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Created by thotap on 5/25/2017.
 */
public class Prime {
  public static void main(String[] args) {

  }

  private static boolean isPrime(int num){
    IntPredicate predicate = index->num%index==0;
    return num>1 && IntStream.range(2,num/2).noneMatch(predicate);
  }
}
