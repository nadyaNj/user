package com.home.user.services.user.model;

import com.home.user.services.common.converter.PersistentLocalDateTimeConverter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/14/15
 * TIME:    11:47 AM
 */
@Entity
@Table(name = "user_model")
public class User implements Serializable {

    private static final long serialVersionUID = -7792685853032593880L;

    @Id
    @SequenceGenerator(name = "sequence_generator", sequenceName = "user_model_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String fistName;

    @Column(name = "second_name")
    private String secondName;

    @Convert(converter = PersistentLocalDateTimeConverter.class)
    @Column(name = "created")
    private LocalDateTime created;

    @Convert(converter = PersistentLocalDateTimeConverter.class)
    @Column(name = "updated")
    private LocalDateTime updated;

    @Convert(converter = PersistentLocalDateTimeConverter.class)
    @Column(name = "removed")
    private LocalDateTime removed;


    /*Getters and setters*/
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
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

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getRemoved() {
        return removed;
    }

    public void setRemoved(final LocalDateTime removed) {
        this.removed = removed;
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
        User rhs = (User) obj;
        return new EqualsBuilder()
                .append(this.getId(), rhs.getId())
                .append(this.getName(), rhs.getName())
                .append(this.getPassword(), rhs.getPassword())
                .append(this.getFistName(), rhs.getFistName())
                .append(this.getSecondName(), rhs.getSecondName())
                .append(this.getCreated(), rhs.getCreated())
                .append(this.getUpdated(), rhs.getUpdated())
                .append(this.getRemoved(), rhs.getRemoved())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getName())
                .append(getPassword())
                .append(getFistName())
                .append(getSecondName())
                .append(getCreated())
                .append(getUpdated())
                .append(getRemoved())
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", getName())
                .append("password", getPassword())
                .append("fistName", getFistName())
                .append("secondName", getSecondName())
                .append("created", getCreated())
                .append("updated", getUpdated())
                .append("removed", getRemoved())
                .toString();
    }
}
