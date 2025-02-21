package com.example.SpringSecurityAuthentication.repo;

import com.example.SpringSecurityAuthentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo extends JpaRepository<UserModel, Long> {
}
