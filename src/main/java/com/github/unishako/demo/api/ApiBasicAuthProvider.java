package com.github.unishako.demo.api;

import com.github.unishako.demo.persistence.entity.Users;
import com.github.unishako.demo.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Log
@RequiredArgsConstructor
public class ApiBasicAuthProvider implements AuthenticationProvider {

    //https://qiita.com/niwasawa/items/fc0f23e97f7fb2a8d3be
    //https://qiita.com/aikumi/items/256b7892effd5c92a39f
    //https://springboot-domamaster-maintenance-sample.readthedocs.io/ja/latest/05-spring_security.html
    //https://qiita.com/tharao/items/cc9276780d69387cfefa

    private final UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        BigDecimal inputName = new BigDecimal(authentication.getName());
        String inputPassword = authentication.getCredentials().toString();

        log.info("inputName=" + inputName);
        log.info("inputPassword=" + inputPassword);

        Users users = usersRepository.findByIdAndPassword(inputName, inputPassword);

        BigDecimal name = BigDecimal.ZERO;
        String password = Strings.EMPTY;

        if (users != null) {
            name = users.getId(); // 正しいユーザ名
            password = users.getPassword(); // 正しいパスワード
        }

        log.info("Name=" + inputName);
        log.info("Password=" + inputPassword);

        if (!name.equals(inputName) || !password.equals(inputPassword)) {
            throw new BadCredentialsException("");
        }
        return new UsernamePasswordAuthenticationToken(inputName, inputPassword, authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
