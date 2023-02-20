package misc;

/**
 * Created by thotap on 4/28/2017.
 */
public class StringCompressor {

  public static void main(String[] args) {
    String input = "aababbbcdcc";
    char[] inputChar = input.toCharArray();
    StringBuilder builder = new StringBuilder();
    char prevChar = inputChar[0];
    int counter = 1;
    for(int i=1; i<inputChar.length; i++){
      char currentChar = inputChar[i];
      if(prevChar == currentChar){
        counter++;
        if(i == inputChar.length-1){
          builder.append(prevChar);
          if(counter>1){
            builder.append(counter);
          }
        }
      }else {
        builder.append(prevChar);
        if(counter>1){
          builder.append(counter);
        }
        counter = 1;
        prevChar = currentChar;
      }
    }
    System.out.println("input: " + input + ", output: " + builder);
  }
}
