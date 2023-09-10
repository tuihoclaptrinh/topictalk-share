package com.anonymity.topictalks.entities.user;

import com.anonymity.topictalks.entities.audit.DateAudit;
import com.anonymity.topictalks.enums.ERole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends DateAudit implements UserDetails {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Size(max = 15)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Email
    @NotNull
    @NaturalId
    @Size(max = 40)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "bio", nullable = false)
    private String bio;

    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @NotNull
    @Column(name = "dob", nullable = true)
    private Instant dob;

    @Column(name = "token", nullable = true)
    private String token;

    @NotNull
    @Column(name = "is_banned", nullable = false)
    private Boolean isBanned;

    @Column(name = "banned_date", nullable = true)
    private Instant bannedDate;

    @Enumerated(EnumType.STRING)
    private ERole role;

    // we should return a list of roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
