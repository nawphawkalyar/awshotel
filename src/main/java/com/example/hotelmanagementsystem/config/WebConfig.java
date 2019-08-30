package com.example.hotelmanagementsystem.config;

import com.example.hotelmanagementsystem.exception.RoomNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Configuration
@ControllerAdvice
public class WebConfig implements WebMvcConfigurer {

  @ExceptionHandler({IllegalArgumentException.class, EntityNotFoundException.class,
          RoomNotFoundException.class, UsernameNotFoundException.class})
  public ModelAndView handleException(HttpServletRequest request,Exception ex){
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("exception",ex);
    modelAndView.addObject("message",ex.getMessage());
    modelAndView.addObject("url",request.getRequestURL());
    modelAndView.setViewName("admin/roomexistederror");
    return modelAndView;
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
      registry.addRedirectViewController("/","/home");
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    return  bCryptPasswordEncoder;
  }


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**")
              .addResourceLocations("/resources/");
  }


}
