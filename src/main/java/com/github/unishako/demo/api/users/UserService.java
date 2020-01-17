package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.common.mapper.MapperUtils;
import com.github.unishako.demo.persistence.entity.Users;
import com.github.unishako.demo.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class UserService {

    private final UsersRepository usersRepository;

    private final MapperUtils mapperUtils;

    public List<UserDto> search(String name) {

        // 入力チェック
        //throw new BadRequestException();

        // データ取得
        List<Users> list = getAllUsers(name);

        // Entity->Dto変換
        List<UserDto> json = mapperUtils.convertList(list, UserDto.class);

        return json;
    }

    private List<Users> getAllUsers(String name) {

        List<Users> list;

        if (Strings.isEmpty(name)) {
            list = usersRepository.findAll();
        } else {
            list = usersRepository.findByNameContaining(name);
        }
        if (list.size() == 0) {
            throw new NotFoundException();
        }
        return list;
    }

    public void auth(String authorization) {
        log.info("Authorization=" + authorization);
    }

}
