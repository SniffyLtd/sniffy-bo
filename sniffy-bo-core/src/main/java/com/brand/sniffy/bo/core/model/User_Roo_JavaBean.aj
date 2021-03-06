// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.utils.UserRole;
import java.util.List;
import java.util.Set;

privileged aspect User_Roo_JavaBean {
    
    public String User.getFirstname() {
        return this.firstname;
    }
    
    public void User.setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String User.getLastname() {
        return this.lastname;
    }
    
    public void User.setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String User.getEmail() {
        return this.email;
    }
    
    public void User.setEmail(String email) {
        this.email = email;
    }
    
    public List<UserRole> User.getRoles() {
        return this.roles;
    }
    
    public void User.setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
    
    public String User.getPassword() {
        return this.password;
    }
    
    public void User.setPassword(String password) {
        this.password = password;
    }
    
    public Set<Device> User.getDevices() {
        return this.devices;
    }
    
    public void User.setDevices(Set<Device> devices) {
        this.devices = devices;
    }
    
    public String User.getLogin() {
        return this.login;
    }
    
    public void User.setLogin(String login) {
        this.login = login;
    }
    
}
