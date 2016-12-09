package com.syrdav.snowtamer;

/**
 * Created by David on 08/12/2016.
 */
public class User {
    int UserId;
    String email;
    String password;

    public User(int UserId,String email, String password){
        this.UserId = UserId;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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
}
