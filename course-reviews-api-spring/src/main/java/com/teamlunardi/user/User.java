package com.teamlunardi.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import core.BaseEntity;

/**
 * Created by akumaldo on 2/17/17.
 */
@Entity
public class User extends BaseEntity {

  public static final PasswordEncoder  PASSWORD_ENCODER = new BCryptPasswordEncoder();
  private String firstName;
  private String lastName;
  private String username;

  @JsonIgnore
  private String[] roles;
  @JsonIgnore
  private String password;

  protected User(){
    super();
  }

  public String getPassword() {
    return password;
  }

  public User(String username,String firstName, String lastName,
              String password, String[] roles) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.roles = roles;
    setPassword(password);
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}