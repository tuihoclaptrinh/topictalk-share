package com.anonymity.topictalks.services;

import com.anonymity.topictalks.entities.user.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    Map<Integer, String> getWsSessions();

    void setWsSessions(Map<Integer, String> wsSessions);

    void deleteAll();

    void flush();

    List<User> findAll();

    void save(User userEntity);

    String findUsernameWithWsToken(String token);

    int findUserIdWithToken(String token);

    User findByNameOrEmail(String str0, String str1);

    boolean checkIfUserIsAdmin(int userId, int groupIdToCheck);

    String createShortUrl(String firstName, String lastName);

    String findUsernameById(int id);

    String findFirstNameById(int id);

    User findById(int id);

    String passwordEncoder(String str);

    boolean checkIfUserNameOrMailAlreadyUsed(String firstName, String mail);

}
