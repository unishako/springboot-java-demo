package com.github.unishako.demo.persistence.repository;

import com.github.unishako.demo.persistence.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UsersRepository extends JpaRepository<Users, BigDecimal> {

}
