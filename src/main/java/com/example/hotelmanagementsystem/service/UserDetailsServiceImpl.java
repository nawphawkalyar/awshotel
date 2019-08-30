package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.model.UserProfile;
import com.example.hotelmanagementsystem.repository.UserProfileRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserProfileRepository userProfileRepository;

  public UserDetailsServiceImpl(UserProfileRepository userProfileRepository) {
    this.userProfileRepository = userProfileRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    return userProfileRepository.findByEmail(email)
            .orElseThrow(() ->new UsernameNotFoundException(email + " Not Found!"));

  }
}
