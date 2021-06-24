package com.cursor.moviereview.annotation.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RateValueDigitsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateValueDigits {

    String message() default "Numeric value out of bounds";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int integer() default 2;

    int fraction() default 2;

}
