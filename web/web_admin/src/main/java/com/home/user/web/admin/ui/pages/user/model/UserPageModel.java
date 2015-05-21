package com.home.user.web.admin.ui.pages.user.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.wicket.markup.html.WebPage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    8:41 PM
 */
public class UserPageModel extends WebPage{

    private static final long serialVersionUID = 4694958652116807815L;

    private String name;
    private String password;
    private String firstName;
    private String secondName;
    private LocalDateTime created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        this.password = hashtext.toString();
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated() {
        this.created = LocalDateTime.now();
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
        UserPageModel rhs = (UserPageModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getName(), rhs.getName())
                .append(this.getPassword(), rhs.getPassword())
                .append(this.getFirstName(), rhs.getFirstName())
                .append(this.getSecondName(), rhs.getSecondName())
                .append(this.getCreated(),rhs.getCreated())
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
                .append(getCreated())
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
                .append("created", getCreated())
                .toString();
    }
}
