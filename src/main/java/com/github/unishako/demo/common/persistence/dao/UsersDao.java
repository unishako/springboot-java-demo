package com.github.unishako.demo.common.persistence.dao;

import com.github.unishako.demo.common.persistence.entity.Users;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UsersDao {

    @Select
    List<Users> selectAll();
}
