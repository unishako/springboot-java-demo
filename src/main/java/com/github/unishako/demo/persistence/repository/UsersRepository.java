package com.github.unishako.demo.persistence.repository;

import com.github.unishako.demo.persistence.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, BigDecimal> {

    List<Users> findByNameContaining(String name);

    Users findByIdAndPassword(BigDecimal id, String password);
}
