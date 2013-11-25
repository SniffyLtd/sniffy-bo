package com.brand.sniffy.bo.core.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.Pattern;
import com.brand.sniffy.bo.core.utils.UserRole;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "users")
public class User {

    /**
     */
    private String firstname;

    /**
     */
    private String lastname;

    /**
     */
    
    private String email;

    /**
     */
    @ElementCollection
    private List<UserRole> roles = new ArrayList<UserRole>();

    /**
     */
    private String password;

    /**
     */
    @NotNull
    private String apiKey;
    
    @ElementCollection
    @CollectionTable(name="user_devices", joinColumns=@JoinColumn(name="user_id"))
    @Column(name="devices")
    private List<String> devices;
}
