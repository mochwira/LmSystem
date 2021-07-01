package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.ApprovalStatus;

import com.lms.LmSystem.repository.ApprovalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApprovalStatusRestController {

    @Autowired
    private ApprovalStatusRepository approvalStatusRepository;

    @GetMapping("/findapproval")
    public ApprovalStatus createFindApproval(@RequestParam("approvalStatusId") Integer approvalStatusId) {
        ApprovalStatus ap = new ApprovalStatus();
        ApprovalStatus apr = approvalStatusRepository.getOne(approvalStatusId);

        //init
        ap.setApprovalStatusId(apr.getApprovalStatusId());
        ap.setStatusApproval(apr.getStatusApproval());

        return ap;
    }
}
