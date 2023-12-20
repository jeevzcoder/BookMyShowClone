package com.projects.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    private int age;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
