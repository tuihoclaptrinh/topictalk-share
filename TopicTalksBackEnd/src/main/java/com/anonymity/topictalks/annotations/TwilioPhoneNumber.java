package com.anonymity.topictalks.annotations;

import com.anonymity.topictalks.validators.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to validate phone number.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface TwilioPhoneNumber {

    String message() default "Invalid phone number";

    Class<?>[] groups() default {}; Class<? extends Payload>[] payload() default {};

}
