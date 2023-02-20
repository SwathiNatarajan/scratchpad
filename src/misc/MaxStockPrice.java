package misc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * Created by thotap on 5/2/2017.
 */
public class MaxStockPrice {
  public static void main(String[] args) {
    int[] prices = {100,30,210,520,20,750};
    Map<Integer, Integer> pricesMap = new HashMap<>();
    for(int i=0; i< prices.length; i++){
      pricesMap.put(i, prices[i]);
    }

    Map<Integer, Integer> sortedMap =
    pricesMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, v1) -> e1,
      LinkedHashMap::new));
  List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(sortedMap.entrySet());
    for(int i=0;i < entrySet.size(); i++){
      for(int j=i+1; j<entrySet.size(); j++){
        if(entrySet.get(i).getKey() < entrySet.get(j).getKey()){
          System.out.print("Buy "+entrySet.get(i).getKey() + " Sell " + entrySet.get(j).getKey() + ", ");
        }
      }
    }
  }
}
