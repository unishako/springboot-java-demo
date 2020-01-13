package com.github.unishako.demo.api.users;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDto {

    private BigDecimal id;

    private String password;

    private String name;
}
