package com.example.sportsbetting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Require authentication to every URL in your application
 * Generate a login form for you
 * Allow the user with the Username user and the Password password to authenticate with form based authentication
 * Allow the user to logout
 * CSRF attack prevention
 * Session Fixation protection
 * Security Header integration
 * HTTP Strict Transport Security for secure requests
 * X-Content-Type-Options integration
 * Cache Control (can be overridden later by your application to allow caching of your static resources)
 * X-XSS-Protection integration
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    /**
     * The configure(HttpSecurity) method defines which URL paths should be secured and which should not.
     * Specifically, the "/" and "/home" paths are configured to not require any authentication. All other paths must be authenticated.
     */
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // .antMatchers("/", "/home").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .antMatcher("/css/**")
                .formLogin()
                // When a user successfully logs in,
                // they will be redirected to the previously requested page that required authentication.
                // There is a custom "/login" page specified by loginPage(), and everyone is allowed to view it.
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Bean
    @Override
    /**
     * As for the userDetailsService() method,
     * it sets up an in-memory user store with a single user.
     * That user is given a username of "user", a password of "password", and a role of "USER".
     */
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails user =
                User.builder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        manager.createUser(user);

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}