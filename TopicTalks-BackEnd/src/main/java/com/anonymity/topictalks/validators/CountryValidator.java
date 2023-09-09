package com.anonymity.topictalks.validators;

import com.anonymity.topictalks.annotations.ValidCountry;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {

    private final Set<String> validCountries;

    public CountryValidator() {
        validCountries = new HashSet<>(Arrays.asList(Locale.getISOCountries()));
    }

    @Override
    public boolean isValid(String country, ConstraintValidatorContext context) {
        return validCountries.contains(country);
    }

}
