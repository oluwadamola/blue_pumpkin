/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.entity;

import java.io.Serializable;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name="users")
@NamedQueries({
        @NamedQuery(name = "User.all", query="SELECT u FROM User u"),
        @NamedQuery(name ="User.findByEmail", query="SELECT u from User u where u.email = :email "),
        @NamedQuery(name ="User.delete", query="DELETE FROM User u where u.userId =:userId")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(nullable = false, length = 25)
    private String firstName;
    @Column(nullable = false, length = 25)
    private String lastName;
    @Column(nullable = false, length = 65, unique = true)
    private String email;
    @Column(nullable = false, length = 11)
    private String phoneNumber;
    private String password;
    @Column(nullable = false, length = 150)
    private String address;

    public User(){}

    public User(int userId) {
        this.userId = userId;
    }
    
    public User(int userId, String firstName, String lastName, String email, String phoneNumber, String password, String address) {
         this(firstName, lastName, email, phoneNumber, password, address);
         this.userId = userId;
    }
    public User(String firstName, String lastName, String email, String phoneNumber, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
