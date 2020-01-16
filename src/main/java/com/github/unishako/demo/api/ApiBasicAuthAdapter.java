package com.github.unishako.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@RequiredArgsConstructor
public class ApiBasicAuthAdapter extends WebSecurityConfigurerAdapter {

    private final ApiBasicAuthProvider apiBasicAuthProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // CSRF対策機能を無効化
        http.csrf().disable();
        http.antMatcher("/users/auth")
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(apiBasicAuthProvider);
    }

}
