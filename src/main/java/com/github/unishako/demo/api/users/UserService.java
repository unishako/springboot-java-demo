package com.github.unishako.demo.api.users;

import com.github.unishako.demo.common.exception.NotFoundException;
import com.github.unishako.demo.persistence.entity.Users;
import com.github.unishako.demo.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    private final ModelMapper modelMapper;

    public List<Users> search(String name) {

        // 認証チェック
        //throw new UnauthorizedException();

        // 入力チェック
        //throw new BadRequestException();

        // データ取得
        List<Users> list = getAllUsers(name);

        // Entity->Dto変換
        //List<UserDto> json = convertDto(list);

        return list;
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

}
