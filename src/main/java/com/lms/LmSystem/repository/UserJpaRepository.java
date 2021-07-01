package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user JOIN role user.role_id = role.role_id WHERE user_id = :userId", nativeQuery = true)
    List<User> getUserById(@Param(value="userId") String userId);

}
