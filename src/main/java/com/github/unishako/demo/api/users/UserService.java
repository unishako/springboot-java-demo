package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.BadRequestException;
import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.common.exception.UnauthorizedException;
import com.github.unishako.demo.common.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String search(String name) {

        // 認証チェック
        //throw new UnauthorizedException();

        // 入力チェック
        //throw new BadRequestException();

        List<Users> list = userRepository.search(name);

        return "aaaaaaaa";
    }
}
