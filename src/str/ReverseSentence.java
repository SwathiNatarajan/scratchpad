package str;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ReverseSentence {

    public String reverseWords(String s) {
        // strip the space in the start and end
        // tokenize by space and then join each word with a single space
        String result = "";
        int fast = s.length()-1;
        int slow = s.length()-1;
         while(fast>=0){
             while(s.charAt(slow)== ' '){
                 slow--;
             }
             fast = slow;
             while(fast>=0 && s.charAt(fast)!=' '){
                 fast--;
             }
             result+= s.substring(fast+1, slow+1);
             if(fast>0){
                 result+=" ";
             }
             slow = fast;
             if(slow <=0){
                 break;
             }
         }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new ReverseSentence().reverseWords(" here is there "));
        System.out.println(new ReverseSentence().reverseWords("a good   example"));
        System.out.println(new ReverseSentence().reverseWords("the sky is blue"));
    }
}
