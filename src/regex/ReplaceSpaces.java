package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thotap on 5/2/2017.
 */
public class ReplaceSpaces {
  public static void main(String[] args) {
    String sampleStr = "this is sample string    for testing";
    Pattern pattern = Pattern.compile("\\s+");
    Matcher matcher = pattern.matcher(sampleStr);
    String repStr = matcher.replaceAll("%20");
    System.out.println("rep str : " + repStr);

  }
}
