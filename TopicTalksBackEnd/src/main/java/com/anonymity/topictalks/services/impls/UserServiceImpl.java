package com.anonymity.topictalks.services.impls;

import com.anonymity.topictalks.entities.user.User;
import com.anonymity.topictalks.repositories.IUserRepository;
import com.anonymity.topictalks.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {


    private PasswordEncoder passwordEncoder;

    private IUserRepository userRepository;

    private Map<Integer, String> wsSessions = new HashMap<>();

    @Override
    public Map<Integer, String> getWsSessions() {
        return wsSessions;
    }

    @Override
    public void setWsSessions(Map<Integer, String> wsSessions) {
        this.wsSessions = wsSessions;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void flush() {
        userRepository.flush();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public String findUsernameWithWsToken(String token) {
        return userRepository.getUsernameWithWsToken(token);
    }

    @Override
    public int findUserIdWithToken(String token) {
        return 0;
    }

    @Override
    public User findByNameOrEmail(String str0, String str1) {
        return null;
    }

    @Override
    public boolean checkIfUserIsAdmin(int userId, int groupIdToCheck) {
        return false;
    }

    @Override
    public String createShortUrl(String firstName, String lastName) {
        return null;
    }

    @Override
    public String findUsernameById(int id) {
        return null;
    }

    @Override
    public String findFirstNameById(int id) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public String passwordEncoder(String str) {
        return null;
    }

    @Override
    public boolean checkIfUserNameOrMailAlreadyUsed(String firstName, String mail) {
        return false;
    }
}
