/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.dao;

import com.bluepumpkin.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class UserDao implements UserDaoLocal {
 
    @PersistenceContext(unitName = "BluePumpkinPU")
    private EntityManager em;
    
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(int userId) {
        return em.find(User.class, userId);
    }

    @Override
    public List<User> getUsers() {
        return em.createNamedQuery("User.all").getResultList();
    }
    @Override
    public void deleteUser(int userId){
        em.remove(userId);
    }
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
   
    
}
