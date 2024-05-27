package com.example.validation.annotation;

import com.example.validation.validator.MyYearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = { MyYearMonthValidator.class})
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyYearMonth {

    String message() default "날짜 형식에 맞지 않습니다(ex, yyyy-MM)";
    String regexp() default  "^\\d{4}-(0[1-9]|1[012])$";
    //String pattern() default  "yyyyMMdd";

    // @NotNull Annotation 코드에서 가져옴
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
