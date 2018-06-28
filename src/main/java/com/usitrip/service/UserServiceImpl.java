package com.usitrip.service;

import com.usitrip.dao.UserMapper;
import com.usitrip.pojo.User;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveTest() throws SchedulerException, ParseException {
        User user = new User();
        user.setUserId(1);
        user.setUserName("usitrip123123123123123123123");
        user.setApiPassword("987");
        user.setPassword("789");
        user.setName("lianghui");
        user.setTelPhone("626-8668-9652");
        user.setCellPhone("13685695423");
        user.setEmail("usitrip@usitrip.com");
        user.setRole(8);
        user.setStatus(1);

        userMapper.updateByPrimaryKeySelective(user);
        System.out.println(1/0);
    }
}
