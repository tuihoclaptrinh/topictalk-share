package com.anonymity.topictalks.validators;

import com.anonymity.topictalks.annotations.TwilioPhoneNumber;
import com.twilio.Twilio;
import com.twilio.rest.lookups.v1.PhoneNumber;
import com.twilio.rest.lookups.v1.PhoneNumberFetcher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<TwilioPhoneNumber, String> {
    private final String twilioAccountSid;
    private final String twilioAuthToken;

    public PhoneNumberValidator() {
        // Initialize Twilio with your credentials
        this.twilioAccountSid = System.getProperty("twilio.account.sid"); // or retrieve from configuration
        this.twilioAuthToken = System.getProperty("twilio.auth.token"); // or retrieve from configuration
        Twilio.init(twilioAccountSid, twilioAuthToken);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return true; // Allow empty values, you can change this behavior if needed.
        }

        // Perform the phone number lookup
        PhoneNumberFetcher phoneNumberFetcher = PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(phoneNumber));

        // Check the response from Twilio's Lookup API
        try {
            PhoneNumber twilioPhoneNumber = phoneNumberFetcher.fetch();
            return twilioPhoneNumber != null && twilioPhoneNumber.getCarrier() != null;
        } catch (Exception e) {
            // Handle exceptions (e.g., network errors) if necessary
            return false;
        }
    }

}
