package com.anonymity.topictalks.payload.request;

import com.anonymity.topictalks.annotations.NullOrNotBlank;
import com.anonymity.topictalks.annotations.StrongPassword;
import com.anonymity.topictalks.annotations.ValidCountry;
import com.anonymity.topictalks.enums.ERole;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String imageUrl;

    private String token;

    private Boolean isBanned;

    private Instant bannedDate;

    private ERole role;

}
