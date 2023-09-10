package com.anonymity.topictalks.repositories;

import com.anonymity.topictalks.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User getUserByFirstNameOrEmail(String firstName, String mail);

    @Query(value = "SELECT u.first_name, u.last_name FROM user u WHERE u.user_id = :userId", nativeQuery = true)
    String getUsernameById(@Param(value = "userId") long userId);

    @Query(value = "SELECT u.first_name FROM user u WHERE u.user_id = :userId", nativeQuery = true)
    String getFirstNameById(@Param(value = "userId") long userId);

    @Query(value = "SELECT u.first_name FROM user u WHERE u.token = :token", nativeQuery = true)
    String getUsernameWithWsToken(@Param(value = "token") String token);

    @Query(value = "SELECT u.user_id FROM user u WHERE u.token = :token", nativeQuery = true)
    int getUserIdWithWsToken(@Param(value = "token") String token);

    int countAllByFirstNameOrEmail(String firstName, String mail);

    int countAllByImageUrl(String imageUrl);

}
