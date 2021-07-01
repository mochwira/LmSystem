package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.ApprovalStatus;
import com.lms.LmSystem.entity.Role;
import com.lms.LmSystem.repository.ApprovalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApprovalStatusController {

    @Autowired
    private ApprovalStatusRepository approvalStatusRepository;

    @GetMapping("/approval")
    public String createIndexApproval(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepository.findAll(new PageRequest(page, 4)));
        model.addAttribute("approvals", approvalStatusRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageApproval", page);
        model.addAttribute("buatApproval", new ApprovalStatus());
        return "/approval/approval_status.html";
    }

    @PostMapping("/saveapproval")
    public String saveApproval(ApprovalStatus approvalStatus) {
        approvalStatusRepository.save(approvalStatus);

        return "redirect:/approval";
    }

    @GetMapping("/deleteapproval")
    public String deleteApproval(@RequestParam("approvalStatusId") int approvalStatusId) {
        approvalStatusRepository.deleteById(approvalStatusId);

        return "redirect:/approval";
    }
}
