package com.cursor.moviereview.annotation.validation.constraint;

import com.cursor.moviereview.entity.Rate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class RateValueInRangeValidator implements ConstraintValidator<RateValueInRange, Rate> {

    private String min;
    private String max;

    public void initialize(RateValueInRange constraint) {
        min = constraint.min();
        max = constraint.max();
    }

    public boolean isValid(Rate rate, ConstraintValidatorContext context) {
        var value = rate.getValue();
        return value.compareTo(new BigDecimal(min)) >= 0 && value.compareTo(new BigDecimal(max)) <= 0;
    }
}
