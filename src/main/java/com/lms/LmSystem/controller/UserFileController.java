package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.User;
import com.lms.LmSystem.interfaces.UserFile;
import com.lms.LmSystem.repository.UserReportRepository;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class UserFileController {

    @Autowired
    private UserReportRepository userReportRepo;

    @Autowired
    private UserFile userFile;

    @GetMapping("/file")
    public String index() {
        return "/file/userfile.html";
    }

    @GetMapping("/userfile")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        List<User> users = (List<User>)userReportRepo.findAll();
        ByteArrayInputStream byteArrayInputStream = userFile.export(users);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=user.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());

    }
}
