package com.validly.validator;

import java.util.List;
import java.util.function.Predicate;

public final class ValidationEngineString extends ValidationEngine<String, ValidationEngineString> {

    protected ValidationEngineString(String value) {
        super(value);
    }

    protected ValidationEngineString(String fieldName, String value, Notification note) {
        super(fieldName, value, note);
    }

    protected ValidationEngineString(String value, List<String> note) {
        super(value, note);
    }

    public ValidationEngineString mustNotBeEmpty() {
        return must(PredicateUtil.isNotEmpty(), "mustNotBeEmpty");
    }

    public ValidationEngineString lengthMustNotExceed(int max) {
        return must(PredicateUtil.isWithinMax(max), "lengthMustNotExceed");
    }

    public ValidationEngineString lengthMustBeAtLeast(int min) {
        return must(PredicateUtil.isWithinMin(min), "lengthMustBeAtLeast");
    }

    public ValidationEngineString lengthMustBeWithin(int min, int max) {
        return must(PredicateUtil.isWithinMin(min)
                .and(PredicateUtil.isWithinMax(max)), "lengthMustBeWithin");
    }

    public ValidationEngineString mustContain(String value) {
        return must(s -> s.contains(value), "mustContain");
    }

    public ValidationEngineString mustStartWith(String value) {
        return must(s -> s.startsWith(value), "mustStartWith");
    }

    public ValidationEngineString must(Predicate<String> predicate, String message) {
        return (ValidationEngineString) super.must(predicate, message);
    }


}

