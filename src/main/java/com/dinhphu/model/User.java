package com.dinhphu.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="date_of_birth",columnDefinition = "DATE")
    private String dateOfBirth;

    @Column(name="avatar_url")
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name="role_id")
    private UserRole userRole;

    public User() {
    }

    public User(String name, String dateOfBirth, UserRole userRole) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.userRole = userRole;
    }

    public User(String name, String dateOfBirth, String avatarUrl, UserRole userRole) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.avatarUrl = avatarUrl;
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
