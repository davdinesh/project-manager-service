package com.learn.pmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.pmapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
