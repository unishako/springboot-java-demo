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
@RequiredArgsConstructor
@Log
public class ApiBasicAuthProvider implements AuthenticationProvider {

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

        log.info("Name=" + name);
        log.info("Password=" + password);

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
