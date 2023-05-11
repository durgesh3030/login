package com.login.login.entity;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

//@AllArgsConstructor
@Entity
@Table (name = "users" , uniqueConstraints ={ @UniqueConstraint (columnNames = {"username"}),
        @UniqueConstraint(columnNames ={ "email"}) })
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "first_name")
    private String FirstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "email")
    private  String email;
    @Column(name = "username")
    private String  username;
    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<> ();



    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public User( String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getFirstName () {
        return FirstName;
    }

    public void setFirstName ( String firstName ) {
        FirstName = firstName;
    }

    public String getLastName () {
        return LastName;
    }

    public void setLastName ( String lastName ) {
        LastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public Set<Role> getRoles () {
        return roles;
    }


    public User() {
    }
}
