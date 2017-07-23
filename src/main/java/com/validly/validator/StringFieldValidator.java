package com.validly.validator;

import java.util.List;
import java.util.function.Predicate;

public final class StringFieldValidator extends FieldValidator<String, StringFieldValidator> {

    protected StringFieldValidator(String value) {
        super(value);
    }

    protected StringFieldValidator(String fieldName, String value, Notification note) {
        super(fieldName, value, note);
    }

    protected StringFieldValidator(String value, List<String> note) {
        super(value, note);
    }

    public StringFieldValidator mustNotBeEmpty() {
        return must(ValidationRules.isNotEmpty(), "mustNotBeEmpty");
    }

    public StringFieldValidator lengthMustNotExceed(int max) {
        return must(ValidationRules.isWithinMax(max), "lengthMustNotExceed");
    }

    public StringFieldValidator lengthMustBeAtLeast(int min) {
        return must(ValidationRules.isWithinMin(min), "lengthMustBeAtLeast");
    }

    public StringFieldValidator lengthMustBeWithin(int min, int max) {
        return must(ValidationRules.isWithinMin(min)
                .and(ValidationRules.isWithinMax(max)), "lengthMustBeWithin");
    }

    public StringFieldValidator mustContain(String value) {
        return must(s -> s.contains(value), "mustContain");
    }

    public StringFieldValidator mustStartWith(String value) {
        return must(s -> s.startsWith(value), "mustStartWith");
    }

    public StringFieldValidator must(Predicate<String> predicate, String message) {
        return (StringFieldValidator) super.must(predicate, message);
    }


}


