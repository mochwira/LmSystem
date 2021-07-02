package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.ApprovalStatus;

import java.util.List;
import java.util.Optional;

public interface ApprovalStatusInterface {
    Iterable<ApprovalStatus> getActiveApprovalStatus();
    Iterable<ApprovalStatus> getAll();
    Optional<ApprovalStatus> findById(String id);
    //    List<ProductCategory> getMax();
    void deleteApprovalStatusById(String id);
    void save(ApprovalStatus approvalStatus);
    public ApprovalStatus update(ApprovalStatus approvalStatus);
    List<ApprovalStatus> getApprovalStatusById(Integer id);
}
