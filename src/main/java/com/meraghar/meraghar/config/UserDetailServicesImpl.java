package com.meraghar.meraghar.config;

import com.meraghar.meraghar.dao.UserRepo;
import com.meraghar.meraghar.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServicesImpl implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepo.getUserByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("Invalid User Name...");
        }
        CustomUserDetail customUserDetail=new CustomUserDetail(user);

        return customUserDetail;
    }
}
