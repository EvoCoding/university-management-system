package org.example.universitymanagementsystem.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.universitymanagementsystem.annotation.validator.NullOrNotBlankValidator;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = NullOrNotBlankValidator.class
)
public @interface NullOrNotBlank {
    String message() default "{jakarta.validation.constraints.NullOrNotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
