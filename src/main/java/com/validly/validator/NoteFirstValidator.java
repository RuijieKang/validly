package com.validly.validator;

import java.util.List;

public class NoteFirstValidator {

    // STRING
    public static PreConditionString field(String fieldName, String value, ValidlyNote note) {
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
    public static PreConditionInteger field(String fieldName, Integer value, ValidlyNote note) {
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
    public static <T> PreCondition<T, ValidationEngine> field(String fieldName, T value, ValidlyNote note) {
        ValidationEngine<T, ValidationEngine> validationEngine = new ValidationEngine<>(fieldName, value, note);
        validationEngine.setFailOnFirst(true);
        return new PreCondition<>(validationEngine);
    }
    public static <T> PreCondition<T, ValidationEngine> field(T value, List<String> note) {
        ValidationEngine<T, ValidationEngine> validationEngine = new ValidationEngine<>(value, note);
        validationEngine.setFailOnFirst(true);
        return new PreCondition<>(validationEngine);
    }

}
