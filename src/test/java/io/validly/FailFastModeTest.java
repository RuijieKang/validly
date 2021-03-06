package io.validly;

import io.validly.excpetion.ValidationErrorException;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.assertTrue;

public class FailFastModeTest {

    @Test
    public void testWhen() throws Exception {
        Consumer<String> rule = value -> FailFastValidator.valid(value)
                .mustNotBeNull("mustNotBeNull")
                .when(s -> s.startsWith("123"), Then.must(s -> s.endsWith("789"), "must end 789"))
                .when(s -> s.startsWith("987"), Then.must(s -> s.endsWith("321"), "must end 321"));

        success("123 789", rule);
        success("987 321", rule);
        success("111 111", rule);
        failure("123 123", rule, "must end 789");
        failure("987 123", rule, "must end 321");
        failure(null, rule, "");
    }

    @Test
    public void testMust() throws Exception {
        Consumer<String> rule = value -> FailFastValidator.valid(value)
                .mustNotBeNull("mustNotBeNull")
                .must(s -> s.startsWith("123"), "must start 123")
                .must(s -> s.endsWith("999"), "must end 999");

        success("123999", rule);
        success("123 999", rule);
        failure("123", rule, "must end 999");
        failure("999", rule, "must start 123");
        failure("111", rule, "must start 123");
        failure(null, rule, "");
    }

    @Test
    public void testStringBasics() throws Exception {
        Consumer<String> rule = value -> FailFastValidator.valid(value)
                .mustNotBeBlank("mustNotBeBlank")
                .lengthMustBeAtLeast(2, "lengthMustBeAtLeast")
                .lengthMustNotExceed(3, "lengthMustNotExceed");

        success("22", rule);
        success("333", rule);
        failure("1", rule, "");
        failure("4444", rule, "");
        failure("", rule, "");
    }

    @Test
    public void testIntegerBasics() throws Exception {
        Consumer<Integer> rule = value -> FailFastValidator.valid(value)
                .mustNotBeNull("mustNotBeNull")
                .valueMustBeAtLeast(1, "valueMustBeAtLeast")
                .valueMustNotExceed(10, "valueMustNotExceed");

        success(1, rule);
        success(3, rule);
        success(10, rule);
        failure(0, rule, "");
        failure(15, rule, "");
        failure(null, rule, "");
    }

    private <T> void failure(T value, Consumer<T> rule, String expectedMessage) {
        try {
            rule.accept(value);
            Assert.fail("No failure for: " + value);
        } catch (ValidationErrorException e) {
            print(expectedMessage + " -> " + e.getMessage());
            assertTrue(e.getMessage().contains(expectedMessage));
        }
    }

    private <T> void success(T value, Consumer<T> rule) {
        rule.accept(value);
    }

    private void print(String message) {
        System.out.println(message);
    }

}
