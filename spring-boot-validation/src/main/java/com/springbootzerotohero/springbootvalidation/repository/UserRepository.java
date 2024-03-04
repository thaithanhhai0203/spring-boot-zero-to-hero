package com.springbootzerotohero.springbootvalidation.repository;

import com.springbootzerotohero.springbootvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserId(int id);
}
