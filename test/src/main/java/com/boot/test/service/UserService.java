package com.boot.test.service;

import com.boot.test.entity.User;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);
}
