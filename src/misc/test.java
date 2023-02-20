package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by thotap on 5/25/2017.
 */
public class test {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
    String str = "Implemented Marquee zoom" +
      "Developed Unified Logging API" +
      "Implemented Grid UI" +
      "Done Stateless Process changes on NGIS side" +
      "Implemented Deliverableset story along with Connector API" +
      "Worked on SE branching and deployement script to CF" +
      "Got SE up & running on Leap Platform" +
      "Improved SE and connector collaboration" +
      "Fixed SE runtime & IE browser performance issues" +
      "SE data migration to Leap Platform" +
      "Worked on pilot project HGTS" +
      "Enhanced SE functional test framework" +
      "Done Localization fixes" +
      "SE Logger improvisation";
    System.out.println("str.length() = " + str.length());
//    int sum = list.stream().filter(i-> i!=3).map( x -> (int )x*x).collect(Collectors.toMap((i,j)-> i,HashMap::new))sorted(Map.Entry.comparingByValue()).collect();
//    System.out.println(sum);
  }
}
