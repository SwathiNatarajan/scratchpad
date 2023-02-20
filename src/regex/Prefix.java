package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thotap on 4/30/2017.
 */
public class Prefix {
  public static void main(String[] args) {
    String[] words = {"hello", "world", "hello world", "hey dude", "galaxy"};
    List<String> prefixList = new ArrayList<>();
    Pattern pattern = Pattern.compile("^he");
    for(String word: words) {
      Matcher matcher = pattern.matcher(word);
      if(matcher.find()){
        prefixList.add(word);
      }
    }
    prefixList.forEach(word->{System.out.print(word+ " ");});
  }
}
