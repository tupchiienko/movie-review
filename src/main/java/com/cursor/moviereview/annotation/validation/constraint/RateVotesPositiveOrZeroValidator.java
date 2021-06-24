package com.cursor.moviereview.annotation.validation.constraint;

import com.cursor.moviereview.entity.Rate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RateVotesPositiveOrZeroValidator implements ConstraintValidator<RateVotesPositiveOrZero, Rate> {
    public void initialize(RateVotesPositiveOrZero constraint) {
    }

    public boolean isValid(Rate rate, ConstraintValidatorContext context) {
        return rate.getVotesCount() >= 0;
    }
}
