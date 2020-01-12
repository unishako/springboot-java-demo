package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.common.persistence.dao.UsersDao;
import com.github.unishako.demo.common.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UsersDao usersDao;

    public List<Users> search(String name) {

        List<Users> list = usersDao.selectAll();
        if (list.size() == 0) {
            throw new NotFoundException();
        }
        return list;
    }
}
