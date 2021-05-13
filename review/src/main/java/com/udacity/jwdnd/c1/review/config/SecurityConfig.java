package com.udacity.jwdnd.c1.review.config;

import com.udacity.jwdnd.c1.review.service.AuthenticationService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private AuthenticationService authService;

   @Override
   protected void configure(AuthenticationManagerBuilder auth) {
      auth.authenticationProvider(authService);
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
              .antMatchers("/login", "/signup", "/css/**", "/js/**")
                  .permitAll()
              .anyRequest().authenticated();
      http.formLogin()
              .loginPage("/login")
                  .permitAll()
              .defaultSuccessUrl("/chat", true);
   }

}
