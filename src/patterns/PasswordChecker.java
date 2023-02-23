package patterns;

public class PasswordChecker {

    // requirements
    //The website considers a password to be strong if it satisfies the following criteria:
    //
    //Its length is at least .
    //It contains at least one digit.
    //It contains at least one lowercase English character.
    //It contains at least one uppercase English character.
    //It contains at least one special character. The special characters are: !@#$%^&*()-+


    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    // most useful way is regex
    // (?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)
    // (?=.*[a-z])        // use positive look ahead to see if at least one lower case letter exists
    //(?=.*[A-Z])        // use positive look ahead to see if at least one upper case letter exists
    //(?=.*\d)           // use positive look ahead to see if at least one digit exists
    //(?=.*\W)           // use positive look ahead to see if at least one non-word character exists



    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        return 0;
    }

}
