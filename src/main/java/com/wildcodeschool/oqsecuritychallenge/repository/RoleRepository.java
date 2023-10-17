package com.wildcodeschool.oqsecuritychallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.oqsecuritychallenge.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
