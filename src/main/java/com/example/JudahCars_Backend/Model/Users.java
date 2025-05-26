package com.example.JudahCars_Backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String fullName;
    private String email;
    private String password;
    private Boolean isSeller;
    private String phone;

    public Users() {
    }

    public Users(Integer userId, String fullName, String email, String password, Boolean isSeller, String phone) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.isSeller = isSeller;
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSeller() {
        return isSeller;
    }

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
