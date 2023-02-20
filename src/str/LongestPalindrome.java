package str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thotap on 5/1/2017.
 */
public class LongestPalindrome {
  public static void main(String[] args) {
    String sampStr = "aadcbaabcdbbdcbaabcd";
    List<String> palindromes = new ArrayList<>();
    char[] chars =  sampStr.toCharArray();
    for(int i=0; i<chars.length;i++){
      for (int j=i; j < chars.length; j++){
        if(isPalindrome(sampStr.substring(i,j+1))){
          palindromes.add(sampStr.substring(i,j+1));
        }
      }
    }
    String maxPal = "";
    for(String pal: palindromes){
      if(pal.length() > maxPal.length()){
        maxPal = pal;
      }
    }
    System.out.println("maxPal = " + maxPal);

//    System.out.println("Palindrome: " + isPalindrome("cbaabc"));
  }

  private static boolean isPalindrome(String str){
    if(str!=null && str.trim().length() > 0) {
      char[] chars = str.toCharArray();
            for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
        if (chars[i] != chars[j]) {
          return false;
        }
      }
//      int mid = chars.length%2==0? (chars.length/2-1): chars.length-1/2;
//      for (int i = 0, j = chars.length - 1; i < mid; i++, j--) {
//        if (chars[i] != chars[chars.length - 1 - i]) {
//          return false;
//        }
//      }
//      for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
//        if (chars[i] != chars[chars.length - 1 - i]) {
//          return false;
//        }
//      }
      return true;
    }
    return false;
  }

}
