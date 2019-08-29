package com.example.hotelmanagementsystem.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class WebMvcSecurity extends WebSecurityConfigurerAdapter {


  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public WebMvcSecurity(BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

    /*
     .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/posts").permitAll()
            .antMatchers("/authors").permitAll()
            .antMatchers("/post").hasRole("ADMIN")
            .antMatchers("/author").hasRole("ADMIN")
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .usernameParameter("email")
            .and()
            .logout()
            .and()
            .rememberMe()
            .and()
            .csrf()
            .disable()
            ;

     */

  @Override
  protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/layout/**").permitAll()
                .antMatchers("/view/**").permitAll()
                .antMatchers("/room/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                ;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
              .withUser("kyaw")
              .password(bCryptPasswordEncoder.encode("kyaw"))
              .roles("ADMIN")
              .and()
              .withUser("thaw")
              .password(bCryptPasswordEncoder.encode("thaw"))
              .roles("USER");
  }


  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
            .antMatchers("/resources/**");
  }
}
