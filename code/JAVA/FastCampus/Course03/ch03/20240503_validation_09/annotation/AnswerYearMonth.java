package com.example.validation.annotation;

import com.example.validation.validator.AnswerYearMonthValidator;
import com.example.validation.validator.MyYearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = { AnswerYearMonthValidator.class})
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotBlank // 필수값임을 명시
public @interface AnswerYearMonth {

    String message() default "날짜 형식에 맞지 않습니다(ex, 202404)";
    String pattern() default  "yyyyMMdd";

    // @NotNull Annotation 코드에서 가져옴
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
