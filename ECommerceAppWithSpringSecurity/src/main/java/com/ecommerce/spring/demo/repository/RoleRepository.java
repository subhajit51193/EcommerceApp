package com.ecommerce.spring.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.spring.demo.model.ERole;
import com.ecommerce.spring.demo.model.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
