package stack;

public class MatchingParentheses {

    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '{' || temp == '[' || temp == '(') {
                stack.push(temp);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if ((pop == '{' && temp!= '}')
                || (pop == '(' && temp!= ')')
                || (pop == '[' && temp!= ']')) {
                    return false;
                }
            }
        }
       return true;
    }
}