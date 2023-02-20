package leetcode;

import java.util.function.Predicate;

public class CapitalDetector {
    // return true string is
    // all cap
    // first letter cap
    // all small

    // approaches
    // regex
    // check each char
    private static final Predicate<Character> condition = Character::isLowerCase;
    private static final Predicate<String> checkForLower = s -> s.chars()
            .anyMatch(i -> condition.test((char) i));
    private static final Predicate<String> checkForUpper = s -> s.chars()
            .anyMatch(i -> condition.negate().test((char) i));

    public boolean check(String value) {

        if (value.isBlank()) {
            return false;
        }

        if (Character.isUpperCase(value.charAt(0))
                && Character.isUpperCase(value.charAt(1))
                && checkForLower.test(value)) {
          return false;
        }

        return !Character.isLowerCase(value.charAt(1))
                || !checkForUpper.test(value.substring(1));
    }
}
