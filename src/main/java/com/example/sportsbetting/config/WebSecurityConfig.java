package com.example.sportsbetting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
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
                // Tell that we want to authorize some requests
                .authorizeRequests()
                // We want to authorize every requests except resources
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                // We want to use login form
                .formLogin()
                // Define the layout of the login form
                .loginPage("/login")
                // If the user successfully logged in, redirect to the home page.
                .successForwardUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("david")
                .password(encoder.encode("david"))
                .roles("USER").build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        return manager;

    }
}