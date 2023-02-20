package stringandarray;

/**
 * Created by natars5 on 9/15/2017.
 */
public class UniqueCharacters {

    // determine to see if a string has all unique characters

    public static void main(String[] args){
    //    String test ="aditianirudh";
        String test ="abcdefjklmnopqrstuvwxyz";
        UniqueCharacters uCh = new UniqueCharacters();
        System.out.println("does "+ test +" have duplicates? "+ uCh.findDuplicate(test));
        System.out.println("reverse of "+ test + " is :"+ uCh.reverseString(test));
    }

    private boolean findDuplicate(String test){
        boolean duplicateFound= false;
        for(int i=0;i<test.length()-1;i++)
        {
            for(int j= i+1;j<test.length();j++){
                if(test.charAt(i)==test.charAt(j)){
                    duplicateFound=true;
                    break;
                }
            }
        }
        return duplicateFound;
    }

    private String reverseString(String test){
        int length = test.length();
        int j = 0;
        char[] reversed = new char[length];
        for(int i= length-1;i>=0;i--){
            reversed[j] = test.charAt(i);
            j++;
        }
        return String.valueOf(reversed);
    }

}
