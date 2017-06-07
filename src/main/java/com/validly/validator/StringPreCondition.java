package com.validly.validator;

public final class StringPreCondition extends PreCondition<String, StringFieldValidator> {

    public StringPreCondition(FieldValidator<String, StringFieldValidator> fieldValidator) {
        super(fieldValidator);
    }

    public StringFieldValidator mustNotBeBlank() {
        this.fieldValidator.setNullIsValid(false);
        this.fieldValidator.must(ValidationRules.isNotBlank(), Conditions.mustNotBeBlank);
        return (StringFieldValidator) this.fieldValidator;
    }

    @Override
    public StringFieldValidator mustNotBeNull() {
        return (StringFieldValidator) super.mustNotBeNull();
    }

    @Override
    public StringFieldValidator mustNotBeNullWhen(boolean value) {
        return (StringFieldValidator) super.mustNotBeNullWhen(value);
    }

    @Override
    public StringFieldValidator validateWhenNotNull() {
        return (StringFieldValidator) super.validateWhenNotNull();
    }

    @Override
    public StringPreCondition validateWhen(boolean validate) {
        return (StringPreCondition) super.validateWhen(validate);
    }
}