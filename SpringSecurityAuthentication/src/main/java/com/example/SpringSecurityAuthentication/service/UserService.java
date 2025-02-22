package com.example.SpringSecurityAuthentication.service;

import com.example.SpringSecurityAuthentication.model.UserModel;
import com.example.SpringSecurityAuthentication.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@Service
public class UserService {

    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    create user
    public UserModel createUser(UserModel userModel) {


        userModel.setPassword(encoder.encode(userModel.getPassword()));

        if(userModel == null ) {
            return null;
        }

        return userRepo.save(userModel);
    }
}
