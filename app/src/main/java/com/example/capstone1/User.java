package com.example.capstone1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private String Phone;
    private String Name;
    private String Password;


    public User() { }

    public User(String Phone,String Name,String Password) {
        this.Phone = Phone;
        this.Name = Name;
        this.Password = Password;

    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
