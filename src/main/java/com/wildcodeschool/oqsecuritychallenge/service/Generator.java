package com.wildcodeschool.oqsecuritychallenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wildcodeschool.oqsecuritychallenge.entity.Role;
import com.wildcodeschool.oqsecuritychallenge.entity.UserEntity;
import com.wildcodeschool.oqsecuritychallenge.repository.RoleRepository;
import com.wildcodeschool.oqsecuritychallenge.repository.UserRepository;


@Service
public class Generator {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bcryptEncoder;

    public Generator(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bcryptEncoder = passwordEncoder;
    }

    public void generateRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("CHAMPION"));
        roles.add(new Role("DIRECTOR"));
        roleRepository.saveAll(roles);
    }

    public void generateUserList() {
        Role champion = roleRepository.findById(1L).get();
        Role director = roleRepository.findById(2L).get();
        

        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity("Steve", bcryptEncoder.encode("motdepasse"), champion));
        users.add(new UserEntity("Nick", bcryptEncoder.encode("flerken"), director));

        userRepository.saveAll(users);
    }

    

    
}
