package utilities;

import org.testng.Assert;

/**
 * AssertHelper is a utility class that provides custom assertion methods
 * to simplify test assertions and improve readability.
 */
public class AssertHelper {

    /**
     * Asserts that the given condition is true.
     * @param condition the condition to check
     * @param message   the message to display if the assertion fails
     */
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Asserts that the expected and actual strings are equal.
     * @param expected the actual value
     * @param actual   the expected value
     */
    public static void assertEqual(String expected, String actual) {
        Assert.assertEquals("The actual value \"" + actual + "\" does not match the expected value \"" + expected + "\".",
                expected, actual);
    }

    /**
     * Asserts that the expected and actual strings are not equal.
     * @param actual   the actual value
     * @param expected the expected value
     */
    public static void assertNotEqual(String actual, String expected) {
        Assert.assertNotEquals("The actual value \"" + actual + "\" matches the expected value \"" + expected + "\".",
                expected, actual);
    }

    /**
     * Asserts that the given condition is true.
     * @param condition the condition to check
     */
    public static void assertTrue(boolean condition) {
        Assert.assertTrue(condition, "The condition is not true.");
    }

    /**
     * Asserts that the given condition is false.
     * @param condition the condition to check
     */
    public static void assertFalse(boolean condition) {
        Assert.assertFalse(condition, "The condition is not false.");
    }

    /**
     * Asserts that the given condition is false with a custom message.
     * @param condition the condition to check
     * @param message   the message to display if the assertion fails
     */
    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
}
