package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.ApprovalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalStatusRepository extends JpaRepository<ApprovalStatus, Integer> {
}
