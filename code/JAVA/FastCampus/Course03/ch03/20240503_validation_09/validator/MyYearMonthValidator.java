package com.example.validation.validator;

import com.example.validation.annotation.MyYearMonth;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class MyYearMonthValidator implements ConstraintValidator<MyYearMonth, String> {
    private String regexp;

    @Override
    public void initialize(MyYearMonth constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = Pattern.matches(regexp, value);
        return result;
    }
}
