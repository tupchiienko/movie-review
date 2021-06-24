package com.cursor.moviereview.annotation.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RateVotesPositiveOrZeroValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateVotesPositiveOrZero {

    String message() default "Votes count must not be less than 0";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
