package com.github.unishako.demo.persistence.entity;

import lombok.Data;
import org.seasar.doma.Entity;

import java.math.BigDecimal;

@Entity
@Data
public class Users {

    private BigDecimal id;

    private String name;
}
