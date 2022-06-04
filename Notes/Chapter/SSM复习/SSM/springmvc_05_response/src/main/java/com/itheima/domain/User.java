package com.itheima.domain;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    private Address address;
}
