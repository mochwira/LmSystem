package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.User;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface UserFile {
    ByteArrayInputStream export(List<User> users);
}
