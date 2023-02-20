package misc;

/**
 * Created by thotap on 4/28/2017.
 */
public class PowerOfTwo {
  public static void main(String[] args) {
    int i=17;
    if((i & (i+1)) == 0){
      System.out.println("true");
    }else{
      System.out.println("false");
    }
  }
}
