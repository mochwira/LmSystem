package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoryFix extends JpaRepository<Role, Integer> {

}
