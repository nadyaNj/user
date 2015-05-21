package com.home.user.facade.anotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/15/15
 * TIME:    11:53 AM
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Facade {
}
