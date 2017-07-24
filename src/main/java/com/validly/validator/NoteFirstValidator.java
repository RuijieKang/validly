package com.validly.validator;

import java.util.List;

public class NoteFirstValidator {

    // STRING
    public static PreConditionString field(String fieldName, String value, Notification note) {
        ValidationEngineString validator = new ValidationEngineString(fieldName, value, note);
        validator.setFailOnFirst(true);
        return new PreConditionString(validator);
    }
    public static PreConditionString field(String value, List<String> note) {
        ValidationEngineString validator = new ValidationEngineString(value, note);
        validator.setFailOnFirst(true);
        return new PreConditionString(validator);
    }


    // INTEGER
    public static PreConditionInteger field(String fieldName, Integer value, Notification note) {
        ValidationEngineInteger validator = new ValidationEngineInteger(fieldName, value, note);
        validator.setFailOnFirst(true);
        return new PreConditionInteger(validator);
    }
    public static PreConditionInteger field(Integer value, List<String> note) {
        ValidationEngineInteger validator = new ValidationEngineInteger(value, note);
        validator.setFailOnFirst(true);
        return new PreConditionInteger(validator);
    }


    // GENERIC
    public static <T> PreCondition<T, FieldValidator> field(String fieldName, T value, Notification note) {
        FieldValidator<T, FieldValidator> fieldValidator = new FieldValidator<>(fieldName, value, note);
        return new PreCondition<>(fieldValidator);
    }
    public static <T> PreCondition<T, FieldValidator> field(T value, List<String> note) {
        FieldValidator<T, FieldValidator> fieldValidator = new FieldValidator<>(value, note);
        return new PreCondition<>(fieldValidator);
    }

}
