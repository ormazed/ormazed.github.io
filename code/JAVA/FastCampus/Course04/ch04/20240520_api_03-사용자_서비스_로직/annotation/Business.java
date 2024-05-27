package org.delivery.api.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;
import java.lang.annotation.Retention;

@Target(ElementType.TYPE)
@Service
@Retention(RetentionPolicy.RUNTIME)
public @interface Business {

    @AliasFor(annotation = Service.class)
    String value() default "";

}
