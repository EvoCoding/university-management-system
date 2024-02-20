package org.example.universitymanagementsystem.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.universitymanagementsystem.annotation.NullOrNotBlank;

public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {
    public void initialize(NullOrNotBlank parameters) {
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || !value.trim().isEmpty();
    }
}
