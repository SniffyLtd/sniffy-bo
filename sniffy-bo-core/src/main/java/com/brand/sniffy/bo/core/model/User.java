package com.brand.sniffy.bo.core.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.Pattern;
import com.brand.sniffy.bo.core.utils.UserRole;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "users")
@RooJson
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
    @Column(name="role")
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles = new ArrayList<UserRole>();

    /**
     */
    private String password;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Device> devices = new HashSet<Device>();

    /**
     */
    @Column(unique = true)
    private String login;
}
