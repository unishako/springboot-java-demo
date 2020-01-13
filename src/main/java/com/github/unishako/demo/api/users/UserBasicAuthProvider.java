package com.github.unishako.demo.api.users;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserBasicAuthProvider implements AuthenticationProvider {

    //https://qiita.com/niwasawa/items/fc0f23e97f7fb2a8d3be

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        authentication.getName();
        authentication.getCredentials().toString();

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
