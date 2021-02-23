package com.myorg.cbs.entities;

import lombok.Data;

@Data
public class UserEntity {
    private int userId;
    private String userName;
    private String email;
    private int age;
    private String address;
}
