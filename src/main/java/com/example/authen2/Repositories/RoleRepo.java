package com.example.authen2.Repositories;

import com.example.authen2.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    Set<Role> findByRoleName(String roleName);
}
