package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CapitalDetectorTest {

    CapitalDetector capitalDetector = new CapitalDetector();

    @Test
    public void testDetect() {
        Assertions.assertTrue(capitalDetector.check("Java"));
        Assertions.assertTrue(capitalDetector.check("JAVA"));
        Assertions.assertTrue(capitalDetector.check("java"));
        Assertions.assertFalse(capitalDetector.check("jaVa"));
    }

}
