package com.example.SpringSecurityAuthentication.service;

import com.example.SpringSecurityAuthentication.model.UserModel;
import com.example.SpringSecurityAuthentication.model.UserPrincipal;
import com.example.SpringSecurityAuthentication.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
@NoArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public MyUserDetailService(UserRepo userRepo) {
        this.userRepo  = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepo.findByUsername(username);


        if(userModel == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException( username + "not found");

        }
        return new UserPrincipal(userModel);
    }
}
