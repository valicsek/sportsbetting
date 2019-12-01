package com.example.sportsbetting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

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
    @Autowired
    DataSource dataSource;

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
                .antMatchers("/css/**", "/js/**", "/images/**", "/register").permitAll()
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


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * Create a database based authentication system instead of a memory based.
         */
        auth.jdbcAuthentication()
                /*
                * The dataSource is a wire to application.properties (spring.datasource.*)
                 */
                .dataSource(dataSource)
                // By default we do not store the enabled column. Because of this the enabled set default by 1.
                .usersByUsernameQuery("select email,password, 1 as enabled "
                        + "from user "
                        + "where email = ?")
                // Since we do not have authorities table, I use a dummy sql to have authorities
                .authoritiesByUsernameQuery("select email, 'USER' from user where email = ?");
                /*.authoritiesByUsernameQuery("select email,authority "
                        + "from authorities "
                        + "where email = ?");*/

    }

    // Solve 'There is no PasswordEncoder mapped for the id "null"' error
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*
    LOGIN WITHOUT DATABASE, MEMORY BASED.
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("david")
                .password(encoder.encode("david"))
                .roles("USER").build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        return manager;

    } */
}