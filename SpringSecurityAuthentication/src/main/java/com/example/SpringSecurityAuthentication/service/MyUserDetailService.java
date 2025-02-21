package com.example.SpringSecurityAuthentication.service;

import com.example.SpringSecurityAuthentication.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
@NoArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private UserRepo userRepo;

    public MyUserDetailService(UserRepo userRepo) {
        this.userRepo  = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
