package com.dinhphu.dto;

import com.dinhphu.model.UserRole;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class UserDTO {

    private Integer id;

    private String name;

    private String dateOfBirth;

    private MultipartFile file;

    private UserRole userRole;

    public UserDTO() {
    }

    public UserDTO(String name, MultipartFile file, UserRole userRole) {
        this.name = name;
        this.file = file;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", file=" + file +
                ", userRole=" + userRole +
                '}';
    }
}
