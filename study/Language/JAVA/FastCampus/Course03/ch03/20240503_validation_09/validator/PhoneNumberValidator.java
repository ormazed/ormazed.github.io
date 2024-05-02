package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private String regexp;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
       this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = Pattern.matches(regexp, value);

        return result;
    }
}
// ## debug mode ##
/*javax.validation.ConstraintDefinitionException: HV000074: com.example.validation.annotation.PhoneNumber contains Constraint annotation, but does not contain a groups parameter.
	at org.hibernate.validator.internal.metadata.core.ConstraintHelper.assertGroupsParameterExists(ConstraintHelper.java:1042) ~[hibernate-validator-6.2.5.Final.jar:6.2.5.Final]
*/