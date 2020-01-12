package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.BadRequestException;
import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.common.exception.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String search(String name) {

        // 認証チェック
        //throw new UnauthorizedException();

        // 入力チェック
        throw new BadRequestException();

        // 0件エラー
        //throw new NotFoundException();

        //return "aaaaaaaa";
    }
}
