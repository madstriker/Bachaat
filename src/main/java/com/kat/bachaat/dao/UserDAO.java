package com.kat.bachaat.dao;

import com.kat.bachaat.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    List<User> getUsers();

    User getUserByUserName(String firstName);

}
