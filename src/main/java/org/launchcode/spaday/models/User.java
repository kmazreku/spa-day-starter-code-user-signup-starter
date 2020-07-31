package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @NotBlank
    @Size(min=5, max=15, message="Invalid Username! Username should be between 5 and 15 characters long.")
    private String username;

    @NotBlank
    @Email(message="Invalid email! Enter valid email.")
    private String email;

    @NotBlank
    @Size(min=6, message="Password is too short. Password should be at least 6 characters long.")
    private String password;

    public User(){}
    public User(String username, String email, String password){
        this.username = username;
        this.email =email;
        this.password= password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
