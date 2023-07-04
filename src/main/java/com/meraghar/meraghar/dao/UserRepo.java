package com.meraghar.meraghar.dao;

import com.meraghar.meraghar.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("Select u from User u where u.email= :email")
    public User getUserByUserName(@Param("email") String email);
}
