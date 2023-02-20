package regex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thotap on 4/22/2017.
 */
public class Regex {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("C:\\temp\\test.txt"));
    String line = null;
    Matcher matcher = null;
    Pattern pattern = Pattern.compile("(^<<.*>>$)");
    int lineNum = 1;
    while((line = reader.readLine())!=null){
      matcher = pattern.matcher(line);
      if(!matcher.find()){
        System.out.println("Syntax doesn't match at line " + lineNum + ", line is " + line);
      }
      lineNum++;
    }
    String EXAMPLE_TEST ="<<test to test duplicates>>";


//    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
//    // check all occurance
//   if (matcher.find()) {
//      System.out.print("Start index: " + matcher.start());
//      System.out.print(" End index: " + matcher.end() + " ");
//      System.out.println(matcher.group());
//    }
  }
}
