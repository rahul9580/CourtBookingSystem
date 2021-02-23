package com.myorg.cbs.dtos;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String email;
    private int age;
    private String address;
}
