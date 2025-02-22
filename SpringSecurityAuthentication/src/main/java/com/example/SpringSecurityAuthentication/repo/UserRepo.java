package com.example.SpringSecurityAuthentication.repo;

import com.example.SpringSecurityAuthentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);
}
