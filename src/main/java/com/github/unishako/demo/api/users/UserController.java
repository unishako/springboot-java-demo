package com.github.unishako.demo.api.users;

import com.github.unishako.demo.persistence.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/search")
    public List<UserDto> search(@RequestParam (required = false) String name) {
        return userService.search(name);
    }

    @GetMapping("/auth")
    public void auth(@RequestHeader("Authorization") String authorization) {

    }
}
