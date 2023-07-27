package com.oneHealth.User.Services;

import java.util.List;
import java.util.Optional;

import com.oneHealth.User.Entity.User;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User saveUser(User user);

    void deleteUser(Long id);
}
