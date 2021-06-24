package com.cursor.moviereview.annotation.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RateValueInRangeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateValueInRange {

    String message() default "Rate value out of range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String max() default "10.0";

    String min() default "0.0";

}
