package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.ApprovalStatus;
import com.lms.LmSystem.interfaces.ApprovalStatusInterface;
import com.lms.LmSystem.repository.ApprovalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalStatusService implements ApprovalStatusInterface {

    @Autowired
    private ApprovalStatusRepository approvalStatusRepository;


    @Override
    public Iterable<ApprovalStatus> getActiveApprovalStatus() {
        return approvalStatusRepository.getActiveApprovalStatus();
    }

    @Override
    public Iterable<ApprovalStatus> getAll() {
        return approvalStatusRepository.findAll();
    }

    @Override
    public Optional<ApprovalStatus> findById(String id) {
        return approvalStatusRepository.findById(id);
    }

    //Ingat Delete By Id Itu Default bukan di tambahin
    @Override
    public void deleteApprovalStatusById(String id) {
        approvalStatusRepository.deleteById(id);
    }

    @Override
    public void save(ApprovalStatus approvalStatus) {
        approvalStatusRepository.save(approvalStatus);
    }

    @Override
    public ApprovalStatus update(ApprovalStatus approvalStatus) {
        return approvalStatusRepository.save(approvalStatus);
    }

    @Override
    public List<ApprovalStatus> getApprovalStatusById(Integer id) {
        return approvalStatusRepository.getApprovalStatusById(id);
    }
}
