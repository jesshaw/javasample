package com.lexiangmiao.sample.servicemember.service;

import com.lexiangmiao.sample.servicemember.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getById(Integer id) {
        User result = new User();
        result.setUserName("zhangshan");
        return result;
    }
}
