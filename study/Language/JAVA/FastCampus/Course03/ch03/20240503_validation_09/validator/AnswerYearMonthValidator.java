package com.example.validation.validator;

import com.example.validation.annotation.AnswerYearMonth;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class AnswerYearMonthValidator implements ConstraintValidator<AnswerYearMonth, String> {
    private String pattern;

    @Override
    public void initialize(AnswerYearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // yyyy-MM-dd => yyyy-MM 으로 반환
        var reValue =  value + "01";
        var rePattern = pattern + "dd";

        try {
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
