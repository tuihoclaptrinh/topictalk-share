package com.anonymity.topictalks.payload.request;

import com.anonymity.topictalks.annotations.NullOrNotBlank;
import com.anonymity.topictalks.annotations.StrongPassword;
import com.anonymity.topictalks.annotations.TwilioPhoneNumber;
import com.anonymity.topictalks.annotations.ValidCountry;
import com.anonymity.topictalks.models.user.enums.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NullOrNotBlank(message = "First name can not be blank")
    private String firstName;

    @NullOrNotBlank(message = "Last name can not be blank")
    private String lastName;

    @NullOrNotBlank(message = "Username can not be blank")
    private String username;

    @Email
    @NullOrNotBlank(message = "User email cannot be null")
    private String email;

    @NullOrNotBlank(message = "Password cannot be null")
    @StrongPassword
    private String password;

    @NullOrNotBlank
    private String bio;

    @NullOrNotBlank
    private String gender;

    @NullOrNotBlank
    private String phoneNumber;

    @ValidCountry
    @NullOrNotBlank
    private String country;

    private Instant dob;

    private Boolean isBanned;

    private Instant bannedDate;

    private ERole role;

}
