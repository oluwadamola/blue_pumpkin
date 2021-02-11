/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.dao;

import com.bluepumpkin.entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface UserDaoLocal {
    void addUser(User user);
    User getUser(int userId);
    List<User> getUsers();
    User getUserByEmail(String email);
    void deleteUser(int userId);
    void updateUser(User user); 
    int count();
}
