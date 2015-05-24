package com.home.user.web.admin.ui.pages.user.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    8:41 PM
 */
public class UserPageModel implements Serializable {

    private static final long serialVersionUID = 4694958652116807815L;


    /*Properties*/
    private String name;

    private String password;

    private String firstName;

    private String secondName;


    /*Getters and setters*/
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final UserPageModel rhs = (UserPageModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getName(), rhs.getName())
                .append(this.getPassword(), rhs.getPassword())
                .append(this.getFirstName(), rhs.getFirstName())
                .append(this.getSecondName(), rhs.getSecondName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getName())
                .append(getPassword())
                .append(getFirstName())
                .append(getSecondName())
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", getName())
                .append("password", getPassword())
                .append("firstName", getFirstName())
                .append("secondName", getSecondName())
                .toString();
    }
}
