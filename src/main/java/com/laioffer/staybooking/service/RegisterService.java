package com.laioffer.staybooking.service;

import com.laioffer.staybooking.model.Authority;
import com.laioffer.staybooking.model.User;
import com.laioffer.staybooking.model.UserRole;
import com.laioffer.staybooking.repository.AuthorityRepository;
import com.laioffer.staybooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    @Autowired
    public RegisterService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(User user, UserRole role) {
        userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), role.name()));
    }
}