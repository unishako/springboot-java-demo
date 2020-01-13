package com.github.unishako.demo.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Users {

    @Id
    private BigDecimal id;

    private String pass;

    private String name;
}
