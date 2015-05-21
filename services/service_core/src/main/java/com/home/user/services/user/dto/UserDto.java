package com.home.user.services.user.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

 /**
 * Created: Nadya Dainelyan
 * DATE:    5/14/15
 * TIME:    7:25 PM
 */
public class UserDto implements Serializable {

    private static final long serialVersionUID = 3184687195748838283L;

    /* Properties */
    private Long id;

    private String name;

    private String firstName;

    private String secondName;

    private String password;

    private LocalDateTime created;


    /*Getters and Setters*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }


}
