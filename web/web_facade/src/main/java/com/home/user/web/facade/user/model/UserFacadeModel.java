package com.home.user.web.facade.user.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/14/15
 * TIME:    12:23 PM
 */
public class UserFacadeModel implements Serializable {

    private static final long serialVersionUID = 5266402598278505129L;


    /*Properties*/
    private String name;

    private String firstName;

    private String secondName;

    private String password;

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


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        UserFacadeModel rhs = (UserFacadeModel) obj;
        return new EqualsBuilder()
                .append(this.getName(), rhs.getName())
                .append(this.getFirstName(), rhs.getFirstName())
                .append(this.getSecondName(), rhs.getSecondName())
                .append(this.getPassword(), rhs.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getName())
                .append(getFirstName())
                .append(getSecondName())
                .append(getPassword())
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", getName())
                .append("firstName", getFirstName())
                .append("secondName", getSecondName())
                .append("password", getPassword())
                .toString();
    }
}
