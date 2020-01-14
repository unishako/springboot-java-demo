package com.github.unishako.demo.api;

import lombok.extern.java.Log;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Log
public class ApiBasicAuthProvider implements AuthenticationProvider {

    //https://qiita.com/niwasawa/items/fc0f23e97f7fb2a8d3be
    //https://qiita.com/aikumi/items/256b7892effd5c92a39f
    //https://springboot-domamaster-maintenance-sample.readthedocs.io/ja/latest/05-spring_security.html
    //https://qiita.com/tharao/items/cc9276780d69387cfefa

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String inputName = authentication.getName();
        String inputPassword = authentication.getCredentials().toString();

        log.info("inputName=" + inputName);
        log.info("inputPassword=" + inputPassword);

        //TODO DBから正しいユーザ名、パスワードを取得する
        final String name = "user"; // 正しいユーザ名
        final String password = "password"; // 正しいパスワード

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
