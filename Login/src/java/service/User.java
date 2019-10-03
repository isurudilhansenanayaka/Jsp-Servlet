/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author isuru_s
 */
public class User {
    Integer Id;
    String userName;
    String email;
    String password;
    String passwordc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPasswordc() {
        return passwordc;
    }

    public void setPasswordc(String passwordc) {
        this.passwordc = passwordc;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    public User(int Id, String userName, String email) {
        this.Id = Id;
        this.userName = userName;
        this.email = email;
    }
}
