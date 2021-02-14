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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    public User getUserByEmail(String email){
        try{
            TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
            return query.setParameter("email", email).getSingleResult();
         }
        catch(NoResultException e) {
            return null;
        }        
    }
    @Override
    public List<User> getUsers() {
        return em.createNamedQuery("User.all", User.class).getResultList();
    }
    @Override
    public void deleteUser(User user){
       if(!em.contains(user)){
           user = em.merge(user);
       }
       em.remove(user);
    }
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
   
    @Override
    public int count(){
        return getUsers().size();
    }
}
