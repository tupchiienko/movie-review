package com.cursor.moviereview.annotation.validation.constraint;

import com.cursor.moviereview.entity.Rate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RateValueDigitsValidator implements ConstraintValidator<RateValueDigits, Rate> {

    private int integer;
    private int fraction;

    public void initialize(RateValueDigits constraint) {
        integer = constraint.integer();
        fraction = constraint.fraction();
    }

    public boolean isValid(Rate rate, ConstraintValidatorContext context) {
        var value = rate.getValue();
        var precision = value.precision();
        var scale = value.scale();
        return precision - scale <= integer && scale <= fraction;
    }
}
