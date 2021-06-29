package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReportRepository extends JpaRepository<User, Integer> {

}
