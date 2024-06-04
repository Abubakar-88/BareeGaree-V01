package utilities;


import static org.junit.Assert.assertTrue;

public class AssertionUtils {

        public static <T> void assertEquals(T expected, T actual, String message) {
            assertTrue(message, expected.equals(actual));
        }
    }

