package com.meraghar.meraghar.dao;

import com.meraghar.meraghar.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
